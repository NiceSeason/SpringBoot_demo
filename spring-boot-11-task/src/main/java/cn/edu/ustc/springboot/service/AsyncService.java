package cn.edu.ustc.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    @Async
    public void sayHello() {
        try {
            Thread.sleep(3000);
            System.out.println("hello async task!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
