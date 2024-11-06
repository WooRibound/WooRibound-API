package com.wooribound.api.individual.facade;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserUpdateDTO;
import com.wooribound.domain.userapply.DTO.WbUserApplyDTO;
import com.wooribound.domain.userapply.Service.UserApplyService;
import com.wooribound.domain.wbuser.WbUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WbUserInfoFacade {

    private final UserApplyService userApplyService;
    private final WbUserService wbUserService;

    // 1. 지원 공고 조회
    public List<WbUserApplyDTO> getUserApplyList(UserApplyDTO userApplyDTO) {
        return userApplyService.getUserApplyList(userApplyDTO);
    }

    // 2. 지원 공고 취소
    public String cancelUserApply(UserApplyDTO userApplyDTO) {
        return userApplyService.cancelUserApply(userApplyDTO);
    }

    public List<WbUserDTO> getUserInfo(String userId) {
        return wbUserService.getUserInfo(userId);
    }

    public String updateUserInfo(WbUserUpdateDTO wbUserUpdateDTO) {
        return wbUserService.updateUserInfo(wbUserUpdateDTO);
    }
}