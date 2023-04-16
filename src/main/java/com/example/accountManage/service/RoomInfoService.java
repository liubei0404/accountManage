package com.example.accountManage.service;

import com.example.accountManage.dto.CreateRoomDTO;

public interface RoomInfoService {

    /**
     * 插入房间信息
     * @param creatorUserId
     * @param roomPassword
     * @return
     */
    CreateRoomDTO insertRoomInfo(String creatorUserId, String creatorUserName, String roomPassword);
}
