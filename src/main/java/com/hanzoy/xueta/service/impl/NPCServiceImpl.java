package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.domain.*;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.mapper.DialogueMapper;
import com.hanzoy.xueta.mapper.NpcjlbMapper;
import com.hanzoy.xueta.mapper.RoleMapper;
import com.hanzoy.xueta.service.NPCService;
import com.hanzoy.xueta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NPCServiceImpl implements NPCService {

    @Resource
    RoleMapper roleMapper;

    @Resource
    NpcjlbMapper npcjlbMapper;

    @Autowired
    UserService userService;

    @Resource
    DialogueMapper dialogueMapper;

    @Override
    public void registerUser(int id) {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria();
        long l = roleMapper.countByExample(roleExample);
        for(int i=0; i<l; i++){
            Npcjlb npcjlb = new Npcjlb();
            npcjlb.setUserid(id);
            npcjlb.setNpcid(i+1);
            npcjlb.setFavor(0);
            npcjlb.setIshaving(false);
            npcjlb.setIsdialogue(false);
            npcjlbMapper.insert(npcjlb);
//            npcjlbMapper.insert(npcjlb);
        }
    }

    @Override
    public void triggerThePlot(int userId, int Reid) {
        System.out.println(userId + "触发了"+Reid+"剧情");
    }

    @Override
    public void setReid(int userId, int npcId, int Reid) {
        System.out.println("修改了" + userId + "的"+npcId+"的Reid为"+Reid);
    }

    @Override
    public CommonResult getInfo(String token) {
        User user = userService.getUserByToken(token);

        NpcjlbExample npcjlbExample = new NpcjlbExample();
        npcjlbExample.createCriteria()
                .andUseridEqualTo(user.getId());

        List<Npcjlb> npcjlbs = npcjlbMapper.selectByExample(npcjlbExample);
        List<Role> roles = new ArrayList<>();
        for (Npcjlb npcjlb : npcjlbs) {
            if(npcjlb.getIshaving()){
                Role role = roleMapper.selectByPrimaryKey(npcjlb.getNpcid());
                role.setFavor(npcjlb.getFavor());
                role.setPrice(null);
                Dialogue dialogue = dialogueMapper.selectByPrimaryKey(npcjlb.getReid());
                role.setIsdialogue(dialogue.getIscontinue() || (npcjlb.getPropnumber() != null && npcjlb.getPropnumber() > 0));
                roles.add(role);
            }
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("count", roles.size());
        data.put("info", roles);
        return CommonResult.success(data);
    }
}
