package cn.edu.ustc.springboot.service;

import cn.edu.ustc.springboot.bean.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @RabbitListener(queues = {"admin.test"})
    public void receive1(Object book){
        System.out.println("收到消息："+book.getClass());
    }

//    @RabbitListener(queues = {"admin.test"})
//    public void receive2(Message message){
//        System.out.println("收到消息"+message.getHeaders()+"---"+message.getPayload());
//    }
}
