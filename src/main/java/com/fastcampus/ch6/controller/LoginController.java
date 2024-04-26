package com.fastcampus.ch6.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
		
	/**
	 * Class Name : LoginController.java
	 * Description : 로그인
	 * 
	 * 수정일                수정자        수정내용
	 * 2018.02.27	    홍상현        최초 생성
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request
							,HttpSession session) throws Exception {
		ModelAndView model = new ModelAndView("login");
		String textId = "";
		
		Cookie[] cookies = request.getCookies();
        
		if (cookies != null) {
            for (int i = 0 ; i < cookies.length ; i++) {
                if(cookies[i].getName().equals("cUserId")) {
                	textId = cookies[i].getValue();
                }       
            }
        }
        
		model.addObject("cUserId", textId);
		
		return model;
	}
	
	/**
	 * Class Name : LoginController.java
	 * Description : 모바일 로그인 
	 * 
	 * 수정일                수정자        수정내용
	 * 2018.02.27	    홍상현        최초 생성
	 */
	@RequestMapping(value = "/m/", method = RequestMethod.GET)
	public ModelAndView MLogin(HttpServletRequest request, HttpSession session
								,@CookieValue(value = "cUserId", required=false) Cookie cUserId) throws Exception {
		ModelAndView model = new ModelAndView("m.login");
		String textId = "";
		
		Cookie[] cookies = request.getCookies();
        
		if (cookies != null) {
            for (int i = 0 ; i < cookies.length ; i++) {
                if(cookies[i].getName().equals("mUserId")) {
                	textId = cookies[i].getValue();
                }
                
            }
        }
		
        model.addObject("cUserId", textId);
		
		return model;
	}

}
