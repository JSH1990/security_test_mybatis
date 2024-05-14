package com.fastcampus.ch6.dao;

import com.fastcampus.ch6.domain.LoginVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("LoginDAO")
public class LoginDAO {

    @Autowired
    private SqlSession mybatis;

    public LoginVO getInfo(){
        return mybatis.selectOne("login.getInfo");
    }


}