package com.wooribound.domain.wbuser;

import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserJoinDTO;
import com.wooribound.api.individual.dto.WbUserUpdateDTO;

import java.util.List;

public interface WbUserService {

    WbUserDTO getUserInfo(String userId);

    String updateUserInfo(WbUserUpdateDTO wbUserUpdateDTO);

    void saveWbUser(WbUser wbUser);

    String craeteWbUser(WbUserJoinDTO wbUserJoinDTO);

    WbUserDTO getOneUserInfo(String userId);

    int getJobPoint(String userId);

    WbUser getWbUser(String userId);

    void addWbscore(String userId, int addScore);
}
