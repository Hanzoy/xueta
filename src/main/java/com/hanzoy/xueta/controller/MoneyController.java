package com.hanzoy.xueta.controller;

import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.param.TokenParam;
import com.hanzoy.xueta.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoneyController {

    @Autowired
    MoneyService moneyService;

    @PostMapping("/queryMoney")
    public CommonResult queryMoney(@RequestBody TokenParam param){
        return moneyService.queryMoney(param.getToken());
    }
}
