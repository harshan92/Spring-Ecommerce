package com.harshan92.bookstore.controller;

import com.harshan92.bookstore.domain.User;
import com.harshan92.bookstore.domain.security.PasswordResetToken;
import com.harshan92.bookstore.service.UserService;
import com.harshan92.bookstore.service.impl.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private  UserSecurityService userSecurityService;

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
    public String newAccount(Locale locale, @RequestParam("token") String token, Model model){
        PasswordResetToken passToken=userService.getPasswordResetToken(token);
        if(passToken==null){
            String message="Invalid Token.";
            model.addAttribute("message",message);
            return  "redirect:/badRequest";
        }
        User user=passToken.getUser();
        String username=user.getUsername();
        UserDetails userDetails= userSecurityService.loadUserByUsername(username);
        Authentication authentication=new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        model.addAttribute("classActiveEdit", true);
        return "myProfile";
    }

    @RequestMapping("/forget_password")
    public String forget_password( Model model){

        model.addAttribute("classActiveForgetPassword", true);
        return "myAccount";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String newUserPost(){
        return "";
    }
}
