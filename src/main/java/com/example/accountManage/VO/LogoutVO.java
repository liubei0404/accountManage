package com.example.accountManage.VO;

import lombok.Data;

@Data
public class LogoutVO {
    /**
     * 用户名
     */
    String userName;

    /**
     * 用户Id
     */
    String userId;

    /**
     * 操作是否成功
     */
    boolean successful;

    /**
     * 成功/失败 信息
     */
    String message;
}
