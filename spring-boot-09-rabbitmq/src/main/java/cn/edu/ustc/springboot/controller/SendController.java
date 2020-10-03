package cn.edu.ustc.springboot.controller;

import cn.edu.ustc.springboot.bean.Book;
import cn.edu.ustc.springboot.bean.Student;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SendController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String send() {
        for (int i = 0; i < 10; i++) {
            if (i%2==0){
                Book book = new Book();
                book.setName("水浒传");
                book.setPrice(i);
                rabbitTemplate.convertAndSend("admin.direct","admin.test",book,new CorrelationData(UUID.randomUUID().toString()));
            }else {
                Student student = new Student();
                student.setName("mhs");
                student.setAge(i);
                rabbitTemplate.convertAndSend("admin.direct","admin.test",student,new CorrelationData(UUID.randomUUID().toString()));
            }
        }
        return "success";
    }
}
