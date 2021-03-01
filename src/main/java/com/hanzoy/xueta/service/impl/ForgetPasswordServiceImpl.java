package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.domain.User;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.service.ForgetPasswordService;
import com.hanzoy.xueta.service.UserService;
import com.hanzoy.xueta.service.VerificationCodeService;
import com.hanzoy.xueta.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ForgetPasswordServiceImpl implements ForgetPasswordService {

    @Autowired
    UserService userService;

    @Autowired
    VerificationCodeService verificationCodeService;

    public CommonResult getUser(String username) {

        User user = userService.getUserByUsername(username);

        if(user == null){
            user = userService.getUserByPhone(username);
        }

        if(user == null){
            return CommonResult.fail("1002", "未找到对应username或phone");
        }
        HashMap<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("phone", user.getPhone());
        tokenMap.put("id", user.getId());
        tokenMap.put("username", user.getUsername());
        String token = userService.createTokenFromMap(tokenMap);

        String phone = user.getPhone();
        String sendPhone = "" + phone.charAt(0) + phone.charAt(1) + phone.charAt(2) + "*****" + phone.charAt(8) + phone.charAt(9) + phone.charAt(10);

        HashMap<String, String> data = new HashMap<>();
        data.put("token", token);
        data.put("phone", sendPhone);

        return CommonResult.success(data);
    }

    @Override
    public void sendVerificationCode(String token) {
        userService.check(token);
        Map<String, Object> beanMap = userService.getJWTUtils().getBeanAsMap(token, Object.class);
        String phone = (String)beanMap.get("phone");
        verificationCodeService.sendVerificationCode(phone);
    }

    @Override
    public CommonResult checkVerificationCode(String token, String code) {
        userService.check(token);
        Map<String, Object> beanMap = userService.getJWTUtils().getBeanAsMap(token, Object.class);
        String phone = (String)beanMap.get("phone");
        int id = (int) beanMap.get("id");
        String username = (String) beanMap.get("username");
        if (verificationCodeService.checkVerificationCode(phone, code)) {
            verificationCodeService.deleteVerificationCode(phone);
            HashMap<String, Object> tokenMap = new HashMap<>();
            tokenMap.put("phone", phone);
            tokenMap.put("changPassword", true);
            tokenMap.put("id", id);
            tokenMap.put("username", username);
            String sendToken = userService.createTokenFromMap(tokenMap);
            HashMap<String, String> data = new HashMap<>();
            data.put("token", sendToken);
            return CommonResult.success(data);
        }
        return CommonResult.fail("1002", "验证码校验失败");
    }

    @Override
    public CommonResult changePassword(String token, String password) {
        userService.check(token);
        Map<String, Object> beanMap = userService.getJWTUtils().getBeanAsMap(token, Object.class);
        String username = (String) beanMap.get("username");
        if (!((boolean)beanMap.get("changPassword"))) {
            return CommonResult.fail("1001", "token错误");
        }
//        User user = userService.getUserByPhone(phone);
        User user = userService.getUserByUsername(username);
        user.setPassword(password);
        if(HttpUtils.changePassword(user)){
            userService.updateUser(user);
        }
        return CommonResult.success(null);
    }
}
