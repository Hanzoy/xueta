package com.hanzoy.xueta.service;

import com.hanzoy.xueta.domain.User;
import com.hanzoy.xueta.dto.CommonResult;

public interface UserService {
    CommonResult login(String username, String password);
    User check(String token);
    CommonResult changePassword(User user, String oldPassword, String newPassword);
    CommonResult register(String username, String password, String phone, String verification);
}
