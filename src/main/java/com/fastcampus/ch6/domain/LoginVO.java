package com.fastcampus.ch6.domain;

public class LoginVO {
    private String cpcode;
    private String cdstf;
    private String username;

    public LoginVO(){}

    public LoginVO(String cpcode, String cpstf, String username) {
        this.cpcode = cpcode;
        this.cdstf = cpstf;
        this.username = username;
    }

    public String getCpcode() {
        return cpcode;
    }
    public void setCpcode(String cpcode) {
        this.cpcode = cpcode;
    }
    public String getCdstf() {
        return cdstf;
    }
    public void setCpstf(String cpstf) {
        this.cdstf = cpstf;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}