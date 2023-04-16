package com.example.accountManage.dto;

import lombok.Data;

@Data
public class LoginDTO {
    /**
     * 用户名
     */
    String userName;

    /**
     * 用户Id
     */
    String userId;

    /**
     * 登录是否成功
     */
    boolean successful;

    /**
     * 成功/失败 信息
     */
    String message;

}
