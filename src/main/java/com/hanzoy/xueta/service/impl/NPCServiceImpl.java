package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.domain.*;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.mapper.*;
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

    @Resource
    ContentMapper contentMapper;

    @Resource
    ReplyMapper replyMapper;

    @Override
    public void registerUser(int id) {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria();
        long l = roleMapper.countByExample(roleExample);
        for (int i = 0; i < l; i++) {
            Npcjlb npcjlb = new Npcjlb();
            npcjlb.setUserid(id);
            npcjlb.setNpcid(i + 1);
            npcjlb.setFavor(0);
            npcjlb.setIshaving(false);
            npcjlb.setIsdialogue(false);
            npcjlbMapper.insert(npcjlb);
//            npcjlbMapper.insert(npcjlb);
        }
    }

    @Override
    public void triggerThePlot(int userId, int Reid) {
        System.out.println(userId + "触发了" + Reid + "剧情");
    }

    @Override
    public void setReid(int userId, int npcId, int Reid) {
        System.out.println("修改了" + userId + "的" + npcId + "的Reid为" + Reid);
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
            if (npcjlb.getIshaving()) {
                Role role = roleMapper.selectByPrimaryKey(npcjlb.getNpcid());
                role.setFavor(npcjlb.getFavor());
                role.setPrice(null);
                Dialogue dialogue = dialogueMapper.selectByPrimaryKey(npcjlb.getReid());
                role.setIsdialogue((dialogue.getIscontinue() || (npcjlb.getPropnumber() != null && npcjlb.getPropnumber() > 0)) && dialogue.getNextid() > 0);
                roles.add(role);
            }
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("count", roles.size());
        data.put("info", roles);
        return CommonResult.success(data);
    }

    @Override
    public CommonResult getDialogue(String token, int id) {
        User user = userService.getUserByToken(token);
        Npcjlb npcjlb = npcjlbMapper.selectByPrimaryKey(user.getId(), id);
        Dialogue dialogue = dialogueMapper.selectByPrimaryKey(npcjlb.getReid());
        HashMap<String, Object> data = new HashMap<>();
        if ((!dialogue.getIscontinue() && (npcjlb.getPropnumber() != null && npcjlb.getPropnumber() > 0)) && dialogue.getNextid() > 0) {
            npcjlb.setReid(dialogue.getNextid());
            dialogue = dialogueMapper.selectByPrimaryKey(dialogue.getNextid());
            data.put("isContinue", (dialogue.getIscontinue() || (npcjlb.getPropnumber() != null && npcjlb.getPropnumber() > 0)) && dialogue.getNextid() > 0);
            HashMap<String, Object> info = new HashMap<>();

            ContentExample contentExample = new ContentExample();
            contentExample.createCriteria()
                    .andReidEqualTo(dialogue.getReid());
            ReplyExample replyExample = new ReplyExample();
            replyExample.createCriteria()
                    .andReidEqualTo(dialogue.getReid());

            List<Content> contents = contentMapper.selectByExample(contentExample);
            List<Reply> replies = replyMapper.selectByExample(replyExample);

            List<String> contentsList = new ArrayList<>();
            List<String> repliesList = new ArrayList<>();

            for (Content content : contents) {
                contentsList.add(content.getContent());
            }
            for (Reply reply : replies) {
                repliesList.add(reply.getReply());
            }
            info.put("Reid", dialogue.getReid());
            info.put("content", contentsList);
            info.put("reply", repliesList);
            data.put("info", info);
            npcjlb.setPropnumber(npcjlb.getPropnumber() - 1);
            npcjlbMapper.updateByPrimaryKey(npcjlb);

            return CommonResult.success(data);
        } else if (dialogue.getIscontinue()) {
            npcjlb.setReid(dialogue.getReid());
            data.put("isContinue", (dialogue.getIscontinue() || (npcjlb.getPropnumber() != null && npcjlb.getPropnumber() > 0)) && dialogue.getNextid() > 0);
            HashMap<String, Object> info = new HashMap<>();

            ContentExample contentExample = new ContentExample();
            contentExample.createCriteria()
                    .andReidEqualTo(dialogue.getReid());
            ReplyExample replyExample = new ReplyExample();
            replyExample.createCriteria()
                    .andReidEqualTo(dialogue.getReid());

            List<Content> contents = contentMapper.selectByExample(contentExample);
            List<Reply> replies = replyMapper.selectByExample(replyExample);

            List<String> contentsList = new ArrayList<>();
            List<String> repliesList = new ArrayList<>();

            contentsList.add("你还没回答我的问题呢");
            for (Content content : contents) {
                contentsList.add(content.getContent());
            }
            for (Reply reply : replies) {
                repliesList.add(reply.getReply());
            }
            info.put("Reid", dialogue.getReid());
            info.put("content", contentsList);
            info.put("reply", repliesList);
            data.put("info", info);

            return CommonResult.success(data);
        }
        return CommonResult.fail("1002", "错误");
    }

    @Override
    public CommonResult reply(String token, int npcId, int order, int Reid) {
        User user = userService.getUserByToken(token);
        Npcjlb npcjlb = npcjlbMapper.selectByPrimaryKey(user.getId(), npcId);

        Dialogue dialogue = dialogueMapper.selectByPrimaryKey(npcjlb.getReid());
        HashMap<String, Object> data = new HashMap<>();
        if ((dialogue.getIscontinue() || (npcjlb.getPropnumber() != null && npcjlb.getPropnumber() > 0)) && dialogue.getNextid() > 0) {
            if (npcjlb.getReid() == Reid) {
                ReplyExample replyExamples = new ReplyExample();
                replyExamples.createCriteria()
                        .andReidEqualTo(Reid);
                List<Reply> repliess = replyMapper.selectByExample(replyExamples);
                Reply replys = repliess.get(order);
                npcjlb.setFavor(npcjlb.getFavor() + replys.getFavor());

                dialogue = dialogueMapper.selectByPrimaryKey(dialogue.getNextid());

                npcjlb.setReid(dialogue.getReid());
                dialogue = dialogueMapper.selectByPrimaryKey(dialogue.getReid());
                data.put("isContinue", (dialogue.getIscontinue() || (npcjlb.getPropnumber() != null && npcjlb.getPropnumber() > 0)) && dialogue.getNextid() > 0);
                HashMap<String, Object> info = new HashMap<>();

                ContentExample contentExample = new ContentExample();
                contentExample.createCriteria()
                        .andReidEqualTo(dialogue.getReid());
                ReplyExample replyExample = new ReplyExample();
                replyExample.createCriteria()
                        .andReidEqualTo(dialogue.getReid());

                List<Content> contents = contentMapper.selectByExample(contentExample);
                List<Reply> replies = replyMapper.selectByExample(replyExample);

                List<String> contentsList = new ArrayList<>();
                List<String> repliesList = new ArrayList<>();

                for (Content content : contents) {
                    contentsList.add(content.getContent());
                }
                for (Reply reply : replies) {
                    repliesList.add(reply.getReply());
                }
                info.put("Reid", dialogue.getReid());
                info.put("content", contentsList);
                info.put("reply", repliesList);
                data.put("info", info);

                if(!(boolean)data.get("isContinue")){
                    Role role = roleMapper.selectByPrimaryKey(npcId);
                    HashMap<String, Object> pyc = new HashMap<>();
                    pyc.put("id", npcId);
                    pyc.put("name", role.getName());
                    pyc.put("headPicture", role.getPicture());
                    pyc.put("content", dialogue.getContent());
                    pyc.put("picture", dialogue.getPicture());
                    data.put("pyc", pyc);
                }

                npcjlbMapper.updateByPrimaryKey(npcjlb);

                return CommonResult.success(data);
            } else {
                npcjlb.setReid(dialogue.getReid());
                data.put("isContinue", (dialogue.getIscontinue() || (npcjlb.getPropnumber() != null && npcjlb.getPropnumber() > 0)) && dialogue.getNextid() > 0);
                HashMap<String, Object> info = new HashMap<>();

                ContentExample contentExample = new ContentExample();
                contentExample.createCriteria()
                        .andReidEqualTo(dialogue.getReid());
                ReplyExample replyExample = new ReplyExample();
                replyExample.createCriteria()
                        .andReidEqualTo(dialogue.getReid());

                List<Content> contents = contentMapper.selectByExample(contentExample);
                List<Reply> replies = replyMapper.selectByExample(replyExample);

                List<String> contentsList = new ArrayList<>();
                List<String> repliesList = new ArrayList<>();

                contentsList.add("我似乎没有跟上你的节奏");
                for (Content content : contents) {
                    contentsList.add(content.getContent());
                }
                for (Reply reply : replies) {
                    repliesList.add(reply.getReply());
                }
                info.put("Reid", dialogue.getReid());
                info.put("content", contentsList);
                info.put("reply", repliesList);
                data.put("info", info);

                return CommonResult.success(data);
            }
        }
        return null;
    }
}
