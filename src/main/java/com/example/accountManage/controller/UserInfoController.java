package com.example.accountManage.controller;

import com.example.accountManage.Enum.Message;
import com.example.accountManage.Enum.UserState;
import com.example.accountManage.VO.LoginResultVO;
import com.example.accountManage.VO.LogoutVO;
import com.example.accountManage.VO.RegisterResultVO;
import com.example.accountManage.dto.LoginDTO;
import com.example.accountManage.dto.LogoutDTO;
import com.example.accountManage.dto.RegisterDTO;
import com.example.accountManage.service.UserInfoService;
import com.example.accountManage.util.SHA256Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/userInfo")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterResultVO register(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        String password = requestBody.get("password");
        RegisterResultVO resultVO = new RegisterResultVO();
        if ((!username.isEmpty()) && (!password.isEmpty())) {
            //对密码进行加密处理
            String cryptographicPassword = SHA256Utils.encrypt(password);
            RegisterDTO result = userInfoService.insertUserInfo(username, cryptographicPassword);
            BeanUtils.copyProperties(result, resultVO);
        } else {
            log.error("账号或者密码不能为空");
            resultVO.setSuccessful(false);
            resultVO.setMessage(Message.REGISTER_ERROR.getValue());
        }
        return resultVO;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResultVO login(@RequestBody Map<String, String> requestBody) {
        String userId = requestBody.get("userId");
        String password = requestBody.get("password");
        LoginResultVO resultVO = new LoginResultVO();

        if((userId == null) || (password == null)) {
            resultVO.setSuccessful(false);
            resultVO.setMessage(Message.LOGIN_ERROR.getValue());
            return resultVO;
        }
        LoginDTO resultDTO = userInfoService.checkUserInfo(userId, password);
        BeanUtils.copyProperties(resultDTO, resultVO);
        return resultVO;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public LogoutVO logout(@RequestBody Map<String, String> requestBody) {
        String userId = requestBody.get("userId");
        String username = requestBody.get("username");
        LogoutVO resultVO = new LogoutVO();
        LogoutDTO resultDTO = userInfoService.updateUserState(userId, UserState.OFFLINE.getValue());
        BeanUtils.copyProperties(resultDTO, resultVO);
        resultVO.setUserName(username);
        return resultVO;
    }
}