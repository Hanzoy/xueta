package com.hanzoy.xueta.service;

import com.hanzoy.xueta.dto.CommonResult;

import java.util.Map;

public interface ForgetPasswordService {
    CommonResult getUser(String username);
    void sendVerificationCode(String token);
    CommonResult checkVerificationCode(String token, String code);
    CommonResult changePassword(String token, String password);
}
