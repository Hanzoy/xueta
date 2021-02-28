package com.hanzoy.xueta.controller;

import com.hanzoy.xueta.domain.User;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.param.ChangePasswordParam;
import com.hanzoy.xueta.dto.param.LoginParam;
import com.hanzoy.xueta.dto.param.PhoneParam;
import com.hanzoy.xueta.dto.param.RegisterParam;
import com.hanzoy.xueta.service.UserService;
import com.hanzoy.xueta.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

     @Autowired
     UserService userService;

     @Autowired
     VerificationCodeService verificationCodeService;

     @PostMapping("/login")
     public CommonResult login(@RequestBody LoginParam param){
          return userService.login(param.getUsername(), param.getPassword());
     }

     @PostMapping("/changePassword")
     public CommonResult changePassword(@RequestBody ChangePasswordParam param){
          User user = userService.getUserByToken(param.getToken());
          return userService.changePassword(user, param.getOldPassword(), param.getNewPassword());
     }

     @PostMapping("/register/verification")
     public void registerVerification(@RequestBody PhoneParam param){
          verificationCodeService.sendVerificationCode(param.getPhone());
     }

     @PostMapping("/register/user")
     public CommonResult register(@RequestBody RegisterParam param){
          return userService.register(param.getUsername(), param.getPassword(), param.getPhone(), param.getVerification());
     }


}
