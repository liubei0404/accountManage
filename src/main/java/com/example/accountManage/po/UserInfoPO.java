package com.example.accountManage.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoPO implements Serializable {

    /**
     * 自增id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户资源uuid
     */
    private String uuid;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户状态
     */
    private String userState;
}
