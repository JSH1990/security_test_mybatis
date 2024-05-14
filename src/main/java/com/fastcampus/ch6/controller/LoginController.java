package com.fastcampus.ch6.controller;

import com.fastcampus.ch6.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value="/login/loginPage.do")
    public String loginPage() {
        return "/login/loginPage";
    }

    @RequestMapping(value="/login/accessDenied.do")
    public String accessDeniedPage() throws Exception {
        return "/login/accessDenied";
    }


}