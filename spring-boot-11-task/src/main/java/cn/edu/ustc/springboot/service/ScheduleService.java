package cn.edu.ustc.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Scheduled(cron = "0,1,2,3,4,5,30,50 * * * * 0-7")
    public void schedule() {
        System.out.println("I am executing..");
    }
}
