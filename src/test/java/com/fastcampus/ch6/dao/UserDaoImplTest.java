package com.fastcampus.ch6.dao;

import com.fastcampus.ch6.domain.LoginDto;
import com.fastcampus.ch6.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoImplTest {
@Autowired
private UserDao userDao;

    @Test
    public void testGetUserInfo() throws Exception {
        LoginDto loginDto = new LoginDto();
        loginDto.setId("bbb");
        loginDto.setPwd("bbb");

        LoginDto result = userDao.getUserInfo(loginDto);
        System.out.println("result = " + result);
        assertNotNull(result);  // 결과가 null이 아닌지 확인
        assertEquals("bbb", result.getUsername());  // 결과의 사용자 이름이 기대한 값과 일치하는지 확인
        assertEquals("bbb", result.getPassword());  // 결과의 비밀번호가 기대한 값과 일치하는지 확인
    }
}