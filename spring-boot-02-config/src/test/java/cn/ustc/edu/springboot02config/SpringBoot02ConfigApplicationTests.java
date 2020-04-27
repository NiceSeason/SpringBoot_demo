package cn.ustc.edu.springboot02config;

import cn.ustc.edu.springboot02config.domain.Dog;
import cn.ustc.edu.springboot02config.domain.Person;
import cn.ustc.edu.springboot02config.service.ConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot02ConfigApplicationTests {
    @Autowired
    private Person person;

    @Autowired
    private ConfigService service;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void testService() {
        System.out.println(service);
    }

}
