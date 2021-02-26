package com.hanzoy.xueta.service;

import com.hanzoy.xueta.domain.User;
import com.hanzoy.xueta.dto.CommonResult;

public interface UserService {
    CommonResult check(String username, String password);
    User check(String token);
}
