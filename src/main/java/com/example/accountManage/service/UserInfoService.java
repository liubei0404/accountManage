package com.example.accountManage.service;

import com.example.accountManage.dto.LoginDTO;
import com.example.accountManage.dto.LogoutDTO;
import com.example.accountManage.dto.RegisterDTO;

public interface UserInfoService {

    /**
     * 插入用户信息
     * @param userName
     * @param UserPassword
     * @return
     */
    RegisterDTO insertUserInfo(String userName, String UserPassword);

    /**
     * 根据用户账号核验用户登录信息
     * @param userId
     * @return
     */
    LoginDTO checkUserInfo(String userId, String password);

    /**
     * 更新用户状态
     */
    LogoutDTO updateUserState(String userId, String state);


}
