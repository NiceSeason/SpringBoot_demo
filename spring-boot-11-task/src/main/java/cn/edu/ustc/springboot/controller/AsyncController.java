package cn.edu.ustc.springboot.controller;

import cn.edu.ustc.springboot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    private  AsyncService asyncService;

    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @RequestMapping("/hello")
    public String hello() {
        asyncService.sayHello();
        return "success";
    }


}
