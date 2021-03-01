package com.hanzoy.xueta.service;

import com.hanzoy.xueta.dto.CommonResult;

public interface NPCService {
    void registerUser(int id);
    void triggerThePlot(int userId, int Reid);
    void setReid(int userId, int npcId, int Reid);
    CommonResult getInfo(String token);
    CommonResult getDialogue(String token, int id);
    CommonResult reply(String token, int npcId, int order, int Reid);
}
