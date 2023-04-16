package com.example.accountManage.mapper;

import com.example.accountManage.po.ConferenceInfoPO;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceInfoMapper {
    int insertConferenceInfo(ConferenceInfoPO conferenceInfoPO);
}
