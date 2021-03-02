package com.hanzoy.xueta.controller;

import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.param.TokenParam;
import com.hanzoy.xueta.service.RankingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rankingList")
public class RankingListController {

    @Autowired
    RankingListService rankingListService;

    @PostMapping("/getEmerging")
    public CommonResult getEmerging(@RequestBody TokenParam param){
        return rankingListService.getEmerging(param.getToken());
    }

    @PostMapping("/getGeneral")
    public CommonResult getGeneral(@RequestBody TokenParam param){
        return rankingListService.getGeneral(param.getToken());
    }
}
