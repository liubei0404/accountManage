package com.example.accountManage.dto;

import lombok.Data;

@Data
public class UserInfoDTO {
    /**
     * 用户名
     */
    String userName;

    /**
     * 用户账号
     */
    String userId;

    /**
     * 是否是主持人
     */
    Boolean isCompere;
}
