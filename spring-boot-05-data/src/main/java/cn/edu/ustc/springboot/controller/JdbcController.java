package cn.edu.ustc.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/jdbc")
    public Map<String, Object> query() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM department");
        return maps.get(0);
    }
}
