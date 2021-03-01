package com.hanzoy.xueta.service;

import com.hanzoy.utils.JWTUtils;
import com.hanzoy.xueta.domain.User;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.param.PostTimeParam;

import java.util.Map;

public interface UserService {
    CommonResult login(String username, String password);
    void check(String token);
    CommonResult changePassword(User user, String oldPassword, String newPassword);
    CommonResult register(String username, String password, String phone, String verification);
    User getUserByUsername(String username);
    User getUserByPhone(String phone);
    User getUserByToken(String token);
    JWTUtils getJWTUtils();
    void updateUser(User user);
    String createTokenFromMap(Map<String, ?> map);
    User getUserById(int id);
    CommonResult postPersonTime(PostTimeParam param);
    CommonResult postTeamTime(PostTimeParam param);
    CommonResult getUserInfo(String token, String username);
}
