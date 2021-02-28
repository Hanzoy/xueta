package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.domain.Npcjlb;
import com.hanzoy.xueta.domain.RoleExample;
import com.hanzoy.xueta.mapper.NpcjlbMapper;
import com.hanzoy.xueta.mapper.RoleMapper;
import com.hanzoy.xueta.service.NPCService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class NPCServiceImpl implements NPCService {

    @Resource
    RoleMapper roleMapper;

    @Resource
    NpcjlbMapper npcjlbMapper;

    @Override
    public void registerUser(int id) {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria();
        long l = roleMapper.countByExample(roleExample);
        for(int i=0; i<l; i++){
            Npcjlb npcjlb = new Npcjlb();
            npcjlb.setUserid(id);
            npcjlb.setNpcid((int) (l+1));
            npcjlb.setFavor(0);
            npcjlb.setIshaving(false);
            npcjlb.setIsdialogue(false);
            npcjlbMapper.insertSelective(npcjlb);
//            npcjlbMapper.insert(npcjlb);
        }
    }
}
