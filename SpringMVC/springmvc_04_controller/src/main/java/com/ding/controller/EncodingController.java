package com.ding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodingController {

    // 过滤器解决乱码
    @PostMapping("/e/t")
    public String test1(String name, Model model){
        System.out.println(name);
        model.addAttribute("msg", name);
        return "test";
    }
}
