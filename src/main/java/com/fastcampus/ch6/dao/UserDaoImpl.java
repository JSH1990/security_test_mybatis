package com.fastcampus.ch6.dao;

import com.fastcampus.ch6.domain.LoginDto;
import com.fastcampus.ch6.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession session;

    private static String namespace = "com.fastcampus.ch6.dao.UserMapper.";

    @Override
    public UserDto select() throws Exception{
        return session.selectOne(namespace+"select");
    }

    @Override
    public int deleteAll()throws Exception{
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public int insert(UserDto userDto)throws Exception{
        return session.insert(namespace+"insert", userDto);
    }

    @Override
    public LoginDto getUserInfo(LoginDto loginDto) throws Exception{
        return session.selectOne(namespace+"getUserInfo", loginDto);
    }
}
