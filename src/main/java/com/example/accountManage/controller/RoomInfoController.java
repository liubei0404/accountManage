package com.example.accountManage.controller;

import com.example.accountManage.Enum.Message;
import com.example.accountManage.VO.CreateRoomVO;
import com.example.accountManage.dto.CreateRoomDTO;
import com.example.accountManage.service.RoomInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/roomInfo")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true")
public class RoomInfoController {

    @Autowired
    RoomInfoService roomInfoService;

    @RequestMapping(value = "/createRoom", method = RequestMethod.POST)
    public CreateRoomVO createRoom(@RequestBody Map<String, String> requestBody) {
        String creatorUserId = requestBody.get("userId");
        String creatorUserName = requestBody.get("username");
        String roomPassword = requestBody.get("roomPassword");

        CreateRoomVO createRoomVO = new CreateRoomVO();

        if(creatorUserId == null || creatorUserName == null) {
            createRoomVO.setSuccessful(false);
            createRoomVO.setMessage(Message.USERID_AND_USERNAME_NULL.getValue());
        }
        CreateRoomDTO createRoomDTO = roomInfoService.insertRoomInfo(creatorUserId, creatorUserName, roomPassword);

        createRoomVO.setCreatorUserId(creatorUserId);
        createRoomVO.setRoomId(createRoomDTO.getRoomId());
        createRoomVO.setRoomPassword(roomPassword);
        createRoomVO.setAttendeeMap(createRoomVO.getAttendeeMap());
        createRoomVO.setSuccessful(createRoomDTO.isSuccessful());
        createRoomVO.setMessage(createRoomDTO.getMessage());

        return createRoomVO;
    }
}
