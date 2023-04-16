package com.example.accountManage.runner;

import com.example.accountManage.util.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountManageApplicationRunner implements ApplicationRunner {

    @Autowired
    AccountUtils accountUtils;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //初始化生成账号的值
        accountUtils.initStartUserID();
    }
}
