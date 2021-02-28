package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.service.RedisService;
import com.hanzoy.xueta.service.VerificationCodeService;
import com.hanzoy.xueta.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    RedisService redisService;

    @Override
    public void sendVerificationCode(String phone) {
        String identifyCode;
        //1. 判断是否缓存该账号验证码
        if(redisService.isDelayed(phone)){
            return;
        }
        String returnCode = redisService.getValue(phone);
        if (returnCode!=null) {
            identifyCode = returnCode;
        } else {
            identifyCode = getRandom();
        }
        //2.发送短信
        HttpUtils.sendVerificationCode(phone, identifyCode);
        redisService.setKey(phone, identifyCode);
        redisService.setDelayed(phone, 55);
    }

    @Override
    public boolean checkVerificationCode(String phone, String code) {
        String value = redisService.getValue(phone);
        return value != null && value.equals(code);
    }

    @Override
    public void deleteVerificationCode(String phone) {
        redisService.delete(phone);
        redisService.delete(phone+"delayed");
    }

    private static String getRandom() {
        String num = "";
        for (int i = 0; i < 6; i++) {
            num = num + String.valueOf((int) Math.floor(Math.random() * 9 + 1));
        }
        return num;
    }
}
