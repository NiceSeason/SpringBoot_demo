package cn.ustc.edu.springboot02config.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @RequestMapping("/config")
    public String testConfig() {
        return "hello Config!!";
    }
}
