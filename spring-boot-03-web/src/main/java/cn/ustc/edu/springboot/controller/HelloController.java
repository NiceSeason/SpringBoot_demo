package cn.ustc.edu.springboot.controller;

import cn.ustc.edu.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user")String user) {
        if (user.equals("111")){
            throw new UserNotExistException();
        }
        return "hello springboot web";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello", "success");
        return "success";
    }
}
