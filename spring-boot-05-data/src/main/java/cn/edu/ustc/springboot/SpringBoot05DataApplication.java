package cn.edu.ustc.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.edu.ustc.springboot.mapper")
@SpringBootApplication
public class SpringBoot05DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot05DataApplication.class, args);
    }

}
