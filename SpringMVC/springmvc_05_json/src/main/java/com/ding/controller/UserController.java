package com.ding.controller;

import com.alibaba.fastjson.JSON;
import com.ding.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class UserController {
    @RequestMapping(value = "/j1")
    // @ResponseBody // 它不会走视图解析器
    public String json1() throws JsonProcessingException {

        //jackson, ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        // 创建一个对象
        User user = new User("丁家豪", 3, "男");
        String str = mapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping(value = "/j2")
    // @ResponseBody // 它不会走视图解析器
    public String json2() throws JsonProcessingException {

        //jackson, ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        // 创建一个对象

        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("丁家豪1", 3, "男");
        User user2 = new User("丁家豪2", 3, "男");
        User user3 = new User("丁家豪3", 3, "男");
        User user4 = new User("丁家豪4", 3, "男");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        return mapper.writeValueAsString(users);
    }

    @RequestMapping(value = "/j3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // 不是哟ing
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        Date date = new Date();
        // objectMapper, 时间解析后的默认格式为：Timestamp
        return mapper.writeValueAsString(date);
    }

    @RequestMapping(value = "/j4")
    public String json4() throws JsonProcessingException {

        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("丁家豪1", 3, "男");
        User user2 = new User("丁家豪2", 3, "男");
        User user3 = new User("丁家豪3", 3, "男");
        User user4 = new User("丁家豪4", 3, "男");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        String s = JSON.toJSONString(users);
        return s;
    }
}
