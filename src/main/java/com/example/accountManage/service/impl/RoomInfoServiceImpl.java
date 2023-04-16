package com.example.accountManage.service.impl;

import com.example.accountManage.Enum.Message;
import com.example.accountManage.dto.CreateRoomDTO;
import com.example.accountManage.dto.UserInfoDTO;
import com.example.accountManage.mapper.ConferenceInfoMapper;
import com.example.accountManage.mapper.RoomInfoMapper;
import com.example.accountManage.po.ConferenceInfoPO;
import com.example.accountManage.po.RoomInfoPO;
import com.example.accountManage.service.RoomInfoService;
import com.example.accountManage.util.UUIDUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RoomInfoServiceImpl implements RoomInfoService {

    // 用于保存会议号的HashSet
    private final HashSet<String> roomIdSet = new HashSet<>();

    @Autowired
    RoomInfoMapper roomInfoMapper;

    @Autowired
    ConferenceInfoMapper conferenceInfoMapper;


    @Override
    public CreateRoomDTO insertRoomInfo(String creatorUserId, String creatorUserName, String roomPassword) {
        //新建房间表PO
        RoomInfoPO roomInfoPO = new RoomInfoPO();
        roomInfoPO.setId(null);
        String roomId = generateRoomId();
        roomInfoPO.setRoomId(roomId);
        roomInfoPO.setRoomPassword(roomPassword);
        roomInfoPO.setUuid(UUIDUtils.generateUuid(creatorUserId));
        roomInfoPO.setCompere(creatorUserId);
        //初始化参会人员快照
        Map<String, UserInfoDTO> attendMap = new ConcurrentHashMap<>();
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserName(creatorUserName);
        userInfoDTO.setUserId(creatorUserId);
        userInfoDTO.setIsCompere(true);
        attendMap.put(creatorUserId, userInfoDTO);
        //序列化参会人员快照
        Gson gson = new Gson();
        String attendMapJson = gson.toJson(attendMap);
        roomInfoPO.setAttendee(attendMapJson);

        //将房间信息插入数据库
        int row = roomInfoMapper.insertRoomInfo(roomInfoPO);
        //创建返回值
        CreateRoomDTO createRoomDTO = new CreateRoomDTO();
        if(!(row > 0)){
            throw new RuntimeException("插入房间数据失败");
        }

        //新建用户-会议表PO
        ConferenceInfoPO conferenceInfoPO = new ConferenceInfoPO();
        conferenceInfoPO.setId(null);
        conferenceInfoPO.setUserId(creatorUserId);
        conferenceInfoPO.setUserName(creatorUserName);
        conferenceInfoPO.setRoomId(roomId);
        conferenceInfoPO.setIsCompere(true);
        conferenceInfoPO.setIsMeeting(true);
        conferenceInfoPO.setUuid(roomInfoPO.getUuid());

        //插入用户-会议信息
        row = conferenceInfoMapper.insertConferenceInfo(conferenceInfoPO);
        if(!(row > 0)){
            throw new RuntimeException("插入 用户-会议 数据失败");
        }

        createRoomDTO.setRoomId(roomInfoPO.getRoomId());
        createRoomDTO.setRoomPassword(roomPassword);
        createRoomDTO.setUuid(roomInfoPO.getUuid());
        createRoomDTO.setCompere(roomInfoPO.getCompere());
        createRoomDTO.setAttendeeMap(attendMap);
        createRoomDTO.setSuccessful(true);
        createRoomDTO.setMessage(Message.SUCCESS.getValue());
        return createRoomDTO;

    }

    private String generateRoomId() {
        // 用时间戳作为种子生成随机数
        Random random = new Random(System.currentTimeMillis());
        String roomId ;
        long randomNum;

        do {
            // 生成一个 0 到 9999999999 之间的随机数
            randomNum = random.nextLong() % 10000000000L;
            if (randomNum < 0) {
                randomNum += 10000000000L;
            }
            roomId = String.format("%010d", randomNum);
        } while (roomIdSet.contains(roomId));
        roomIdSet.add(roomId);
        return roomId;
    }
}