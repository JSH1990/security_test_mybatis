//package com.fastcampus.ch6.security;
//
//import com.fastcampus.ch6.domain.LoginDto;
//import org.apache.ibatis.session.SqlSession;
//import org.mybatis.spring.support.SqlSessionDaoSupport;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class SecurityDaoImpl extends SqlSessionDaoSupport implements SecurityDao  {
//
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	SqlSession session;
//
//	@Override
//	public LoginDto Login(LoginDto dto) {
//		return session.selectOne("commons.getUserInfo", dto);
//	}
//
//
//}
//
