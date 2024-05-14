package com.fastcampus.ch6.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.fastcampus.ch6.domain.LoginVO;
import com.fastcampus.ch6.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {


    @Autowired
    LoginService loginService;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @GetMapping("/")
    public String home(Locale locale, Model model) {

        LoginVO loginVO = new LoginVO();
        loginVO = loginService.getInfo();

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );
        model.addAttribute("cpcode", loginVO.getCpcode());
        model.addAttribute("cdstf", loginVO.getCdstf());
        model.addAttribute("username", loginVO.getUsername());

        System.out.println("??");
        return "home";
    }

}