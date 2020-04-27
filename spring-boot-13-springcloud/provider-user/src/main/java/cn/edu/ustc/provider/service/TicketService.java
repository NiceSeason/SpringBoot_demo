package cn.edu.ustc.provider.service;

import org.springframework.stereotype.Service;

@Service
public class TicketService {
    public String getTicket(){
        System.out.println("8003");
        return "《厉害了，我的国》";
    }
}
