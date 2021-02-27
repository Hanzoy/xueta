package com.hanzoy.xueta.controller;

import com.hanzoy.xueta.domain.User;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.param.ChangePasswordParam;
import com.hanzoy.xueta.dto.param.LoginParam;
import com.hanzoy.xueta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

     @Autowired
     UserService userService;

     @PostMapping("/login")
     public CommonResult login(@RequestBody LoginParam param){
          return userService.login(param.getUsername(), param.getPassword());
     }
     @PostMapping("/changePassword")
     public CommonResult changePassword(@RequestBody ChangePasswordParam param){
          User user = userService.check(param.getToken());
          return userService.changePassword(user, param.getOldPassword(), param.getNewPassword());
     }
}
