package cn.edu.ustc.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBoot11TaskApplicationTests {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("今天开会");
        message.setText("物质楼555开会，不要迟到");

        message.setFrom("hongshengmo@163.com");
        message.setTo("1043245239@qq.com");

        javaMailSender.send(message);
    }

    @Test
    void send() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        helper.setSubject("今天开会");
        helper.setText("<b style='color:red'>物质楼555开会，不要迟到</b>",true);

        helper.setFrom("xxx@163.com");
        helper.setTo("xxx@qq.com");

        helper.addAttachment("2.png",new File("D:\\Works\\Note\\images\\图片2.png"));
        helper.addAttachment("3.png",new File("D:\\Works\\Note\\images\\图片3.png"));
        javaMailSender.send(message);
    }

}
