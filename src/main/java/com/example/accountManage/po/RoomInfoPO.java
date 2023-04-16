package com.example.accountManage.po;

import lombok.Data;

@Data
public class RoomInfoPO {

    /**
     * 自增id
     */
    private Integer id;

    /**
     * 房间号
     */
    private String roomId;

    /**
     * 参会密码
     */
    private String roomPassword;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 主持人 账号
     */
    private String compere;

    /**
     * 参会人员的 Map 快照, json字符串
     */
    private String attendee;
}
