package com.fastcampus.ch6.dao;

import com.fastcampus.ch6.domain.LoginDto;
import com.fastcampus.ch6.domain.UserDto;

public interface UserDao {
    UserDto select() throws Exception;

    int deleteAll() throws Exception;

    int insert(UserDto userDto) throws Exception;

    LoginDto getUserInfo(LoginDto loginDto) throws Exception;
}
