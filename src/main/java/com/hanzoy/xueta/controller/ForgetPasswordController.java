package com.hanzoy.xueta.controller;

import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.param.CheckVerificationParam;
import com.hanzoy.xueta.dto.param.ForgetChangePasswordParam;
import com.hanzoy.xueta.service.ForgetPasswordService;
import com.hanzoy.xueta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/forget")
public class ForgetPasswordController {

    @Autowired
    ForgetPasswordService forgetPasswordService;

    @PostMapping("/getUser")
    public CommonResult forgetGetUser(@RequestBody HashMap<String, String> param){
        return forgetPasswordService.getUser(param.get("username"));
    }

    @PostMapping("/verification")
    public void sendVerificationCode(@RequestBody HashMap<String, String> param){
        forgetPasswordService.sendVerificationCode(param.get("token"));
    }

    @PostMapping("/checkVerification")
    public CommonResult checkVerification(@RequestBody CheckVerificationParam param){
        return forgetPasswordService.checkVerificationCode(param.getToken(), param.getVerification());
    }

    @PostMapping("/changePassword")
    public CommonResult changePassword(@RequestBody ForgetChangePasswordParam param){
        return forgetPasswordService.changePassword(param.getToken(), param.getPassword());
    }
}
