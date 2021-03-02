package com.hanzoy.xueta.cronTask;

import com.hanzoy.xueta.mapper.GroupsExtendMapper;
import com.hanzoy.xueta.mapper.LabelExtendMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class UpdateTheList {

    @Resource
    LabelExtendMapper labelExtendMapper;

    @Resource
    GroupsExtendMapper groupsExtendMapper;
//    @Scheduled(cron = "0/10 * * * * ? ")
    @Scheduled(cron = "0 0 0 1/1 * ? ")//每天执行一次
    public void UpdateForEveryDay(){
        labelExtendMapper.setZero();
        log.info("label表完成每日跟新");

        groupsExtendMapper.setZero();
        log.info("groups表完成每日跟新");

    }


}
