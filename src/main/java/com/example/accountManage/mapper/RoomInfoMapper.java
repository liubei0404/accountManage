package com.example.accountManage.mapper;

import com.example.accountManage.po.RoomInfoPO;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomInfoMapper {

    /**
     * 新增房间信息
     * @param roomInfoPO
     * @return
     */
    int insertRoomInfo(RoomInfoPO roomInfoPO);
}
