//package com.fastcampus.ch6.security;
//
//import com.fastcampus.ch6.domain.LoginDto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//	private static final  Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
//
//	private SecurityDaoImpl securityDao;
////	private SaltSource salt;
//	private LoginDto userinfo = new LoginDto();
////	private ShaPasswordEncoder passwordEncoder;
//
//	/*
//	 * BCryptPasswordEncoder : 스프링 시큐리티에서 기본적으로 사용하는 암호화 방식으로 암호화가 될때마다 새로운 값을 생성 (salt x)
//	 * ShaPasswordEncoder : SHA-256 암호화를 사용 (salt o)
//	 */
//
//	public void setSecurityDao(SecurityDaoImpl securityDao) {
//		this.securityDao = securityDao;
//	}
//
//	public void setSalt(SaltSource salt) {
//		this.salt = salt;
//	}
//
//	public void setPasswordEncoder(ShaPasswordEncoder passwordEncoder) {
//		this.passwordEncoder = passwordEncoder;
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return authentication.equals(UsernamePasswordAuthenticationToken.class);
//	}
//
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		// login 페이지에서 지정한 lb_userId, lb_userPw 값을 받는다.
//		String userId = (String) authentication.getPrincipal();
//		String userPw = (String) authentication.getCredentials();
//
//		LoginDto dto = new LoginDto();
//		LoginDto resultDto = new LoginDto();
//		dto.setUserId(userId);
//		dto.setUserPw(passwordEncoder.encodePassword(userPw, salt));
//
//		/* SHA-256 암호화 적용 */
//		UsernamePasswordAuthenticationToken sToken = null;
//
//		logger.info("| ================== authentication ===================");
//		logger.info("| userId : " + dto.getUserId());
//		logger.info("| userPw : " + dto.getUserPw());
//		logger.info("| =====================================================");
//
//		try {
//			/* 인증된 사용자 인지 검사 */
//			userinfo = securityDao.Login(dto);
//
//			/* super  */
//			if(userinfo.getAuthLevel() == 1) {
//				userinfo.setSuperLevel(1);
//				userinfo.setViewLevel(1);
//				userinfo.setTeamLevel(1);
//			} else {
//				userinfo.setSuperLevel(0);
//
//				dto.setUserSeq(userinfo.getUserSeq());
//				int viewCount = securityDao.viewLevelSelect(dto);
//				int teamCount = securityDao.teamLevelSelect(dto);
//
//				if(viewCount >= 1) {
//					userinfo.setViewLevel(1);
//				} else {
//					userinfo.setViewLevel(0);
//				}
//				if(teamCount >= 1) {
//					userinfo.setTeamLevel(1);
//				} else {
//					userinfo.setTeamLevel(0);
//				}
//			}
//
//			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
//
//			if(userinfo.getIsUser()) {
//				/* 인증된 사용자 일경우 권한 부여 */
//				userinfo.setUserId(dto.getUserId());
//				roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//				sToken = new UsernamePasswordAuthenticationToken(userId, userPw, roles);
//				sToken.setDetails(userinfo);
//
//				logger.info("sToken : " + sToken);
//
//			} else {
//				throw new BadCredentialsException("BadCredentials!!");
//			}
//
//		} catch (Exception e) {
//			logger.info("Exception : " + e);
//		}
//
//		return sToken;
//	}
//}
