package com.pennonedu.student_sign_api.controller;

import com.pennonedu.student_sign_api.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class InitController {
    @Autowired
    private AccountMapper accountMapper;

    @PostConstruct
    public void init(){
        System.out.println("部署初始化连接池");
        this.accountMapper.selectByPrimaryKey(1);
    }
}
