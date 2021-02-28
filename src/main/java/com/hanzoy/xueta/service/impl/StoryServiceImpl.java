package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.domain.*;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.mapper.NpcjlbMapper;
import com.hanzoy.xueta.mapper.PropMapper;
import com.hanzoy.xueta.mapper.RoleMapper;
import com.hanzoy.xueta.service.StoryService;
import com.hanzoy.xueta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    UserService userService;

    @Resource
    PropMapper propMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    NpcjlbMapper npcjlbMapper;

    @Override
    public CommonResult getPropList() {
        PropExample propExample = new PropExample();
        propExample.createCriteria();
        List<Prop> props = propMapper.selectByExample(propExample);
        HashMap<String, Object> data = new HashMap<>();
        data.put("count", props.size());
        data.put("info", props);
        return CommonResult.success(data);
    }

    @Override
    public CommonResult getRoleList(String token) {
        User user = userService.getUserByToken(token);
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria();
        List<Role> roles = roleMapper.selectByExample(roleExample);
        NpcjlbExample npcjlbExample = new NpcjlbExample();
        npcjlbExample.setOrderByClause("npcid ASC");
        npcjlbExample.createCriteria()
                .andUseridEqualTo(user.getId());
        List<Npcjlb> npcjlbs = npcjlbMapper.selectByExample(npcjlbExample);
        System.out.println(npcjlbs);
        int i=0;
        for (Role role : roles) {
            role.setDynasty(null);
            role.setTradename(null);
            role.setPortrait(null);
            role.setIshaving(npcjlbs.get(i++).getIshaving());
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("count", roles.size());
        data.put("info", roles);
        return CommonResult.success(data);
    }
}
