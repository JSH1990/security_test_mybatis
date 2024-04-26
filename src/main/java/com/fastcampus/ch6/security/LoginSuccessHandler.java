//package com.fastcampus.ch6.security;
//
//import com.fastcampus.ch6.domain.LoginDto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//public class LoginSuccessHandler implements AuthenticationSuccessHandler{
//
//	private static final  Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);
//
//	private SecurityDaoImpl securityDao;
//
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request
//										,HttpServletResponse response
//										,Authentication authentication)
//												throws IOException,	ServletException {
//
//
//		ObjectMapper om = new ObjectMapper();
//
//		Map<String, Object> map = new HashMap<String, Object>();
//
//		LoginDto userInfo = new LoginDto();
//		map.put("result", true);
//
//		userInfo = (LoginDto)SecurityContextHolder.getContext().getAuthentication().getDetails();
//
//		Cookie cok = new Cookie("cUserId", userInfo.getUserId());
//		cok.setPath("/");
//		// 20220525 지원배 쿠키 수명 변경 30일 -> 로그인시(수명x) 쿠키로 사용하는 데이터가 거의없어 문제없음
//		//cok.setMaxAge(60*60*24*30);
//		cok.setMaxAge(0);
//		response.addCookie(cok);
//
///*		Cookie mCok = new Cookie("mUserId", userInfo.getUserId());
//		mCok.setPath("/m/");
//		mCok.setMaxAge(60*60*24*30);
//		response.addCookie(mCok);*/
//
//		HttpSession session = request.getSession();
//		session.setAttribute("SS_USER_ID", userInfo.getUserId());
//		session.setAttribute("userInfo", userInfo);
//
//		String jsonString = om.writeValueAsString(map);
//		OutputStream out = response.getOutputStream();
//		out.write(jsonString.getBytes());
//	}
//}