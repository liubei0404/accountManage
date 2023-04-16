package com.example.accountManage.service.impl;

import com.example.accountManage.Enum.Message;
import com.example.accountManage.Enum.UserState;
import com.example.accountManage.dto.LoginDTO;
import com.example.accountManage.dto.LogoutDTO;
import com.example.accountManage.dto.RegisterDTO;
import com.example.accountManage.mapper.UserInfoMapper;
import com.example.accountManage.po.UserInfoPO;
import com.example.accountManage.service.UserInfoService;
import com.example.accountManage.util.AccountUtils;
import com.example.accountManage.util.SHA256Utils;
import com.example.accountManage.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public RegisterDTO insertUserInfo(String userName, String UserPassword){
        RegisterDTO result = new RegisterDTO();
        UserInfoPO userInfoPO =new UserInfoPO();
        userInfoPO.setId(null);
        userInfoPO.setUserName(userName);
        userInfoPO.setUserState(UserState.ONLINE.getValue());
        userInfoPO.setUserPassword(UserPassword);
        String uuid = UUIDUtils.generateUuid(userName);
        userInfoPO.setUuid(uuid);
        //生成账号
        String userId = AccountUtils.generateAccount();
        userInfoPO.setUserId(userId);
        int row = userInfoMapper.insertUserInfo(userInfoPO);
        if(row > 0) {
            result.setSuccessful(true);
            result.setUserId(userId);
            result.setUserName(userName);
            result.setMessage(Message.REGISTER_SUCCESS.getValue());
            return result;
        }
        result.setSuccessful(false);
        result.setMessage(Message.REGISTER_ERROR.getValue());
        return result;
    }

    @Override
    public LoginDTO checkUserInfo(String userId, String password) {
        UserInfoPO hadInfo = userInfoMapper.queryUserInfo(userId);
        LoginDTO result = new LoginDTO();
        //如果查不到账号
        if(hadInfo == null) {
            result.setSuccessful(false);
            result.setMessage(Message.LOGIN_NULL.getValue());
            return result;
        }

        //如果查到帐号，则核对密码
        if(checkPassword(hadInfo, password)) {
            result.setSuccessful(true);
            result.setUserId(hadInfo.getUserId());
            result.setUserName(hadInfo.getUserName());
            result.setMessage(Message.LOGIN_SUCCESS.getValue());

            //更新用户状态
            int row = userInfoMapper.updateUserState(userId, UserState.ONLINE.getValue());
        } else {
            result.setSuccessful(false);
            result.setMessage(Message.LOGIN_ERROR.getValue());
        }

        return result;
    }

    @Override
    public LogoutDTO updateUserState(String userId, String state) {
        LogoutDTO logoutDTO = new LogoutDTO();
        logoutDTO.setUserId(userId);
        int row = userInfoMapper.updateUserState(userId, state);
        if(row > 0){
            logoutDTO.setSuccessful(true);
            logoutDTO.setMessage(Message.SUCCESS.getValue());
        } else {
            logoutDTO.setSuccessful(false);
            logoutDTO.setMessage(Message.FAIL.getValue());
        }
        return logoutDTO;
    }

    private boolean checkPassword(UserInfoPO hadInfo, String inputPassword) {
        if(inputPassword == null) {
            return false;
        }
        String cryptographicInputPassword = SHA256Utils.encrypt(inputPassword);
        if(cryptographicInputPassword.equals(hadInfo.getUserPassword())){
            return true;
        }
        return false;
    }
}
