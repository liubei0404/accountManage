package com.example.accountManage.util;

import com.example.accountManage.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountUtils {

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     *账号生成的序列, 起始值为100000
     */

    final static int START_USER_ID = 100000;

    private static int maxUserID = START_USER_ID;

    /**
     * 生成账号的静态方法
     * @return
     */
    public synchronized static String generateAccount() {
        String account = Integer.toString(maxUserID);
        maxUserID++;
        return account;
    }


    /**
     * 系统初始化时，初始化startValue
     */
    public void initStartUserID() {
        //获取数据库中的最大id
        int maxId = userInfoMapper.getMaxId();
        maxUserID = START_USER_ID + maxId;
    }
}
