package com.fastcampus.ch6.service;

import com.fastcampus.ch6.dao.LoginDAO;
import com.fastcampus.ch6.domain.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDAO loginDAO;

    @Override
    public LoginVO getInfo(){
        return loginDAO.getInfo();
    }




}