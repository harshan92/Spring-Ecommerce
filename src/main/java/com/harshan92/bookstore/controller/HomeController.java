package com.harshan92.bookstore.controller;

import com.harshan92.bookstore.domain.security.PasswordResetToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/myAccount")
    public String myAccount(){
        return "myAccount";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("classActiveLogin", true);
        return "myAccount";
    }

    @RequestMapping("/new_account")
    public String newAccount(Model model){
        model.addAttribute("classActiveNewAccount", true);
        return "myAccount";
    }

    @RequestMapping("/forget_password")
    public String forget_password(Locale locale, @RequestParam("token") String token, Model model){
        PasswordResetToken passToken=userService.getPasswordResetToken(token);
        model.addAttribute("classActiveForgetPassword", true);
        return "myAccount";
    }
}
