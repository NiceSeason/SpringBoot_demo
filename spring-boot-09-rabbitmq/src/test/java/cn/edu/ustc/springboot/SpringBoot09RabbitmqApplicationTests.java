package cn.edu.ustc.springboot;

import cn.edu.ustc.springboot.bean.Book;
import cn.edu.ustc.springboot.bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest
class SpringBoot09RabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    void contextLoads() {
//        rabbitTemplate.convertAndSend("amq.direct","ustc","aaaa");
        Book book = new Book();
        book.setName("水浒传");
        book.setPrice(23.2f);
        rabbitTemplate.convertAndSend("admin.direct","admin.test",book);
    }

    @Test
    void send() {
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
    }

    @Test
    void receive() {
        Object o = rabbitTemplate.receiveAndConvert("ustc");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    void admin() {
//        amqpAdmin.declareExchange(new DirectExchange("admin.direct"));
        amqpAdmin.declareQueue(new Queue("admin.test"));
        amqpAdmin.declareBinding(new Binding("admin.test", Binding.DestinationType.QUEUE,"admin.direct","admin.test",null));
    }

}
