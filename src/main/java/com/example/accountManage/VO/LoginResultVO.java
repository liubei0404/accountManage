package com.example.accountManage.VO;

import lombok.Data;

@Data
public class LoginResultVO {
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
