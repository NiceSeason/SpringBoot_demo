package cn.edu.ustc.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println("买到票了:"+ticket);
    }
}
