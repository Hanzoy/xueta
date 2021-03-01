package com.hanzoy.xueta.controller;

import com.hanzoy.xueta.domain.User;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.param.*;
import com.hanzoy.xueta.service.UserService;
import com.hanzoy.xueta.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



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

     @PostMapping("/postPersonTime")
     public CommonResult postPersonTime(@RequestBody PostTimeParam param){
          return userService.postPersonTime(param);
     }

     @PostMapping("/postTeamTime")
     public CommonResult postTeamTime(@RequestBody PostTimeParam param){
          return userService.postTeamTime(param);
     }

     @PostMapping("/getUserInfo")
     public CommonResult getUserInfo(@RequestBody TokenAndUsernameParam param){
          return userService.getUserInfo(param.getToken(), param.getUsername());
     }
}
