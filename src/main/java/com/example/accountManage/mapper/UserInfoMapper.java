package com.example.accountManage.mapper;

import com.example.accountManage.po.UserInfoPO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {

    /**
     * 新增用户数据
     * @param userInfoPO
     * @return
     */
    int insertUserInfo(UserInfoPO userInfoPO);

    /**
     * 查询当前数据库中最大的id值
     * @return
     */
    int getMaxId();

    /**
     * 根据uuid查询相关的用户数据
     * @param userId
     * @return
     */
    UserInfoPO queryUserInfo(String userId);

    /**
     * 根据 用户id 更新用户的状态
     * @param userId
     * @return
     */
    int updateUserState(String userId, String state);


}
