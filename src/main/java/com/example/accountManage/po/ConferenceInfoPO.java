package com.example.accountManage.po;

import lombok.Data;

@Data
public class ConferenceInfoPO {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 用户账号
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 房间号
     */
    private String roomId;

    /**
     * 是否是主持人
     */
    private Boolean isCompere;

    /**
     * 是否在会
     */
    private Boolean isMeeting;

    /**
     * uuid
     */
    private String uuid;

}
