package com.example.accountManage.dto;

import lombok.Data;

@Data
public class LogoutDTO {

    /**
     * 用户Id
     */
    String userId;

    /**
     * 退出是否成功
     */
    boolean successful;

    /**
     * 成功/失败 信息
     */
    String message;
}
