package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.domain.User;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.service.MoneyService;
import com.hanzoy.xueta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    UserService userService;

    @Override
    public CommonResult queryMoney(String token) {
        userService.check(token);
        User user = userService.getUserByToken(token);
        user = userService.getUserById(user.getId());
        HashMap<String, Integer> data = new HashMap<>();
        data.put("money",user.getMoney());
        return CommonResult.success(data);
    }
}
