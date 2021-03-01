package com.hanzoy.xueta.controller;

import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.param.TokenAndIdParam;
import com.hanzoy.xueta.dto.param.TokenParam;
import com.hanzoy.xueta.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/story")
public class StoryController {

    @Autowired
    StoryService storyService;

    @PostMapping("/getPropList")
    public CommonResult getPropList(){
        return storyService.getPropList();
    }

    @PostMapping("/getRoleList")
    public CommonResult getRoleList(@RequestBody TokenParam param){
        return storyService.getRoleList(param.getToken());
    }

    @PostMapping("/buyProps")
    public CommonResult buyProps(@RequestBody TokenAndIdParam param){
        return storyService.buyProps(param.getToken(), param.getId());
    }

    @PostMapping("/buyRoles")
    public CommonResult buyRoles(@RequestBody TokenAndIdParam param){
        return storyService.buyRoles(param.getToken(), param.getId());
    }
}
