package com.hanzoy.xueta.controller;

import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.param.TokenAndIdParam;
import com.hanzoy.xueta.dto.param.TokenParam;
import com.hanzoy.xueta.service.NPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class NPCController {

    @Autowired
    NPCService npcService;

    @PostMapping("/getInfo")
    public CommonResult getInfo(@RequestBody TokenParam param){
        return npcService.getInfo(param.getToken());
    }

    @PostMapping("/getDialogue")
    public CommonResult getDialogue(@RequestBody TokenAndIdParam param){
        return npcService.getDialogue(param.getToken(), param.getId());
    }
}
