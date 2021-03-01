package com.hanzoy.xueta.cronTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UpdateTheList {

    @Scheduled(cron = "0 0 0 1/1 * ? ")
    public void UpdateForEveryDay(){

    }
}
