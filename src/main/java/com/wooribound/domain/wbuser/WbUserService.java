package com.wooribound.domain.wbuser;

import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserUpdateDTO;

import java.util.List;

public interface WbUserService {

    List<WbUserDTO> getUserInfo(String userId);

    String updateUserInfo(WbUserUpdateDTO wbUserUpdateDTO);

    int getJobPoint(String userId);
}
