package com.example.accountManage.VO;

import lombok.Data;

@Data
public class RegisterResultVO {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 登录是否成功
     */
    boolean successful;

    /**
     * 成功/失败 信息
     */
    String message;
}
