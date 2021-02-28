package com.hanzoy.xueta.service.impl;

import com.hanzoy.utils.JWTUtils;
import com.hanzoy.xueta.domain.User;
import com.hanzoy.xueta.domain.UserExample;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.exception.TokenErrorException;
import com.hanzoy.xueta.mapper.UserMapper;
import com.hanzoy.xueta.service.UserService;
import com.hanzoy.xueta.service.VerificationCodeService;
import com.hanzoy.xueta.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    public static final String SING = "SIPC_Hanzoy@xueta";
    public static final int TIME =  60*60*24*7;

    public JWTUtils jwtUtils;

    public UserServiceImpl(){
        jwtUtils = new JWTUtils(SING, TIME);
    }
    @Resource
    UserMapper userMapper;

    @Autowired
    VerificationCodeService verificationCodeService;

    @Override
    public CommonResult login(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.isEmpty()){
            return CommonResult.fail("1000", "用户名或密码错误");
        }
        HashMap<String, String> data = new HashMap<>();
        data.put("token", jwtUtils.createToken(users.get(0)));
        return CommonResult.success("0000", "一切正常", data);
    }

    @Override
    public void check(String token) {
        if(!jwtUtils.checkToken(token)){
            throw new TokenErrorException("失效的token");
        }
    }

    @Override
    public CommonResult changePassword(User user, String oldPassword, String newPassword) {
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        if (!user1.getPassword().equals(oldPassword)) {
            return CommonResult.fail("1000", "用户密码错误");
        }
        user1.setPassword(newPassword);
        if (HttpUtils.changePassword(user1)) {
            userMapper.updateByPrimaryKey(user1);
            return CommonResult.success(null);
        }
        return CommonResult.fail("1002", "修改密码失败");
    }

    @Override
    public CommonResult register(String username, String password, String phone, String verification) {
        if(usernameIsExistence(username)){
            return CommonResult.fail("1003", "用户名已经存在");
        }
        if (!verificationCodeService.checkVerificationCode(phone, verification)) {
            return CommonResult.fail("1003", "账号验证码错误");
        }
        User user = new User();
        user.setPhone(phone);
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insert(user);

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username);

        List<User> users = userMapper.selectByExample(userExample);
        verificationCodeService.deleteVerificationCode(phone);

        HashMap<String, String> data = new HashMap<>();
        data.put("token", jwtUtils.createToken(users.get(0)));


        return CommonResult.success(data);
    }

    @Override
    public User getUserByUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        return users.get(0);
    }

    @Override
    public User getUserByPhone(String phone) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(userExample);
        return users.get(0);
    }

    @Override
    public User getUserByToken(String token) {
        check(token);
        return jwtUtils.getBean(token, User.class);
    }

    @Override
    public JWTUtils getJWTUtils() {
        return jwtUtils;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public String createTokenFromMap(Map<String, ?> map) {
        return JWTUtils.createTokenFromMap(map, SING, TIME);
    }

    private boolean usernameIsExistence(String username){
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        return !users.isEmpty();
    }
}
