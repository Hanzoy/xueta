package com.hanzoy.xueta.service;

import com.hanzoy.xueta.dto.CommonResult;

public interface StoryService {
    CommonResult getPropList();
    CommonResult getRoleList(String token);
    CommonResult buyProps(String token, int id);
    CommonResult buyRoles(String token, int id);
}
