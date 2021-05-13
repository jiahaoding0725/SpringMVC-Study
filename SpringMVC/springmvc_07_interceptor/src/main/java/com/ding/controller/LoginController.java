package com.ding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/goLogin")
    public String login(){
        return "login";
    }


    @RequestMapping("/login")
    public String login(HttpSession httpSession, String username, String password, Model model){
        httpSession.setAttribute("userLoginInfo", username);
        model.addAttribute("username", username);
        return "main";
    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession httpSession){
        httpSession.removeAttribute("userLoginInfo");
        return "redirect:main";
    }
}
