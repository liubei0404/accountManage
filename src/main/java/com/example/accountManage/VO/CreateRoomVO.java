package com.example.accountManage.VO;

import lombok.Data;

import java.util.Map;

@Data
public class CreateRoomVO {
    /**
     * 创建人
     */
    String CreatorUserId;

    /**
     * 房间号
     */
    String roomId;

    /**
     * 参会密码
     */
    String roomPassword;

    /**
     * 参会人员 Map
     */
    Map<String, UserInfoVO> attendeeMap;

    /**
     * 操作是否成功
     */
    boolean successful;

    /**
     * 成功/失败 信息
     */
    String message;

}
