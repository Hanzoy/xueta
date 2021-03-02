package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.domain.GroupsExample;
import com.hanzoy.xueta.domain.User;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.dto.IdAndTimeInfo;
import com.hanzoy.xueta.mapper.GroupsExtendMapper;
import com.hanzoy.xueta.mapper.GroupsMapper;
import com.hanzoy.xueta.service.RankingListService;
import com.hanzoy.xueta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class rankingListServiceImpl implements RankingListService {

    @Autowired
    UserService userService;

    @Resource
    GroupsExtendMapper groupsExtendMapper;

    @Override
    public CommonResult getEmerging(String token) {
        userService.check(token);
        List<IdAndTimeInfo> emerging = groupsExtendMapper.getEmerging();
        HashMap<String, Object> data = new HashMap<>();
        data.put("total" ,emerging.size());
        data.put("info", emerging);
        return CommonResult.success(data);
    }

    @Override
    public CommonResult getGeneral(String token) {
        userService.check(token);
        List<IdAndTimeInfo> emerging = groupsExtendMapper.getGeneral();
        HashMap<String, Object> data = new HashMap<>();
        data.put("total" ,emerging.size());
        data.put("info", emerging);
        return CommonResult.success(data);
    }
}
