package cn.edu.ustc.springboot.service;

import cn.edu.ustc.springboot.bean.Book;
import cn.edu.ustc.springboot.bean.Student;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RabbitListener(queues = {"admin.test"})
@Service
public class BookService {
//    @RabbitListener(queues = {"admin.test"})
//    public void receive1(Object book){
//        System.out.println("1收到消息："+book.getClass());
//    }



//    @RabbitListener(queues = {"admin.test"})
//    public void receive2(Message message){
//        System.out.println("收到消息"+message.getHeaders()+"---"+message.getPayload());
//    }

//    @RabbitListener(queues = {"admin.test"})
//    public void receive3(Message message,Book book){
//        System.out.println("3收到消息：book:"+book.getClass()+"\n" +
//                "message"+message.getClass());
//    }

    @RabbitHandler
    public void receive4(Book book, Message message,Channel channel) throws IOException {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4收到消息：book:" + book);
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        System.out.println(deliveryTag);
        channel.basicNack(deliveryTag,false,false);
    }

    @RabbitHandler
    public void receive5(Student student){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5收到消息：student:" + student);
    }
}
