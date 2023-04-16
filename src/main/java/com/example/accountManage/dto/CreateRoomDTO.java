package com.example.accountManage.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CreateRoomDTO {
    /**
     * 房间号
     */
    String roomId;

    /**
     * 参会密码
     */
    String roomPassword;

    /**
     * 房间uuid
     */
    String uuid;

    /**
     * 主持人 账号
     */
    String compere;

    /**
     * 参会人员Map
     */
    Map<String, UserInfoDTO> attendeeMap;

    /**
     * 操作是否成功
     */
    boolean successful;

    /**
     * 成功/失败 信息
     */
    String message;
}