package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.domain.*;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.mapper.NpcjlbMapper;
import com.hanzoy.xueta.mapper.PropMapper;
import com.hanzoy.xueta.mapper.RoleMapper;
import com.hanzoy.xueta.mapper.UserMapper;
import com.hanzoy.xueta.service.NPCService;
import com.hanzoy.xueta.service.StoryService;
import com.hanzoy.xueta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    UserMapper userMapper;

    @Autowired
    NPCService npcService;

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
        int i = 0;
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

    @Transactional
    @Override
    public CommonResult buyProps(String token, int id) {
        User user = userService.getUserByToken(token);
        user = userMapper.selectByPrimaryKey(user.getId());
        //获取user

        Prop prop = propMapper.selectByPrimaryKey(id);
        if(user.getMoney() < prop.getPrice()){
            return CommonResult.fail("1002", "购买失败");
        }

        //这里可以改成npcjlbMapper.selectByPrimaryKey(user.getId(), id); 我懒得改了
        NpcjlbExample npcjlbExample = new NpcjlbExample();
        npcjlbExample.createCriteria()
                .andNpcidEqualTo(id)
                .andUseridEqualTo(user.getId());
        List<Npcjlb> npcjlbs = npcjlbMapper.selectByExample(npcjlbExample);
        if(!npcjlbs.get(0).getIshaving()){
            return CommonResult.fail("1002", "购买失败");
        }
        user.setMoney(user.getMoney() - prop.getPrice());
        userMapper.updateByPrimaryKey(user);
        //购买产品时将npcjlbs表中的propnumber++；
        if(npcjlbs.get(0).getPropnumber() == null){
            npcjlbs.get(0).setPropnumber(0);
        }
        npcjlbs.get(0).setPropnumber(npcjlbs.get(0).getPropnumber()+1);
        npcjlbMapper.updateByPrimaryKey(npcjlbs.get(0));
        HashMap<String, Object> data = new HashMap<>();
        data.put("money", user.getMoney());
        return CommonResult.success(data);
    }

    @Override
    public CommonResult buyRoles(String token, int id) {
        User user = userService.getUserByToken(token);
        user = userMapper.selectByPrimaryKey(user.getId());
        //获取user

        Role role = roleMapper.selectByPrimaryKey(id);
        if(user.getMoney() < role.getPrice()){
            return CommonResult.fail("1002", "购买失败");
        }

        Npcjlb npcjlb = npcjlbMapper.selectByPrimaryKey(user.getId(), id);
        if (npcjlb.getIshaving()) {
            return CommonResult.fail("1002", "购买失败");
        }
        npcjlb.setIshaving(true);
        npcjlb.setReid(role.getReid());
        npcjlb.setPropnumber(1);
        npcjlb.setFavor(0);
        npcjlbMapper.updateByPrimaryKey(npcjlb);

        user.setMoney(user.getMoney() - role.getPrice());
        userMapper.updateByPrimaryKey(user);

        HashMap<String, Object> data = new HashMap<>();
        data.put("money", user.getMoney());
        return CommonResult.success(data);
    }
}
