package com.hanzoy.xueta.controller;

import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.param.TokenParam;
import com.hanzoy.xueta.service.AphorismService;
import com.hanzoy.xueta.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AphorismController {

    @Autowired
    UserService userService;

    @Autowired
    AphorismService aphorismService;

    @PostMapping("/aphorism")
    public CommonResult getAphorism(@RequestBody TokenParam param){
        String token = param.getToken();
        userService.check(token);
        return aphorismService.getAphorism();
    }
}
