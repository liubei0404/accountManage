package com.example.accountManage.VO;

import lombok.Data;

@Data
public class UserInfoVO {
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
