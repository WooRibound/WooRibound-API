package com.wooribound.domain.wbuser;

import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserUpdateDTO;

import java.util.List;

public interface WbUserService {

    List<WbUserDTO> getUserInfo(String userId);

    String updateUserInfo(WbUserUpdateDTO wbUserUpdateDTO);

    WbUserDTO getOneUserInfo(String userId);

    int getJobPoint(String userId);

    WbUser getWbUser(String userId);

    void addWbscore(String userId, int addScore);
}
