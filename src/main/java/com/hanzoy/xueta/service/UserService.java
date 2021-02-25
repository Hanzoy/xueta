package com.hanzoy.xueta.service;

import com.hanzoy.xueta.dto.CommonResult;

public interface UserService {
    public CommonResult login(String username, String password);
}
