//package com.fastcampus.ch6.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//public class LoginFailureHandler implements AuthenticationFailureHandler {
//
//	private static final  Logger logger = LoggerFactory.getLogger(LoginFailureHandler.class);
//
//	@Override
//	public void onAuthenticationFailure(HttpServletRequest request,
//			HttpServletResponse response, AuthenticationException exception)
//					throws IOException, ServletException {
//
//		HttpSession session = request.getSession();
//		session.setAttribute("SS_LOGIN_SF", "F");
//
//		ObjectMapper om = new ObjectMapper();
//
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("result", false);
//		map.put("message", exception.getMessage());
//
//		String jsonString = om.writeValueAsString(map);
//
//		OutputStream out = response.getOutputStream();
//		out.write(jsonString.getBytes());
//	}
//}