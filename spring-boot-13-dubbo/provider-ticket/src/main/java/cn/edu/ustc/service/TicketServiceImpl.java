package cn.edu.ustc.service;


import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.stereotype.Component;


@EnableDubbo
@Component
@Service
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "Gxx:合肥-北京";
    }
}
