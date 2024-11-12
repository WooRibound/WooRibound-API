package com.wooribound.api.individual.facade;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserUpdateDTO;
import com.wooribound.domain.userapply.dto.WbUserApplyDTO;
import com.wooribound.domain.userapply.Service.UserApplyService;
import com.wooribound.domain.wbuser.WbUserService;
import com.wooribound.global.util.AuthenticateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WbUserInfoFacade {

    private final UserApplyService userApplyService;
    private final WbUserService wbUserService;
    private final AuthenticateUtil authenticateUtil;

    // 1. 지원 공고 조회
    @Transactional(readOnly = true)
    public List<WbUserApplyDTO> getUserApplyList(UserApplyDTO userApplyDTO) {
        return userApplyService.getUserApplyList(userApplyDTO);
    }

    // 2. 지원 공고 취소
    @Transactional
    public String cancelUserApply(UserApplyDTO userApplyDTO) {
        return userApplyService.cancelUserApply(userApplyDTO);
    }

    // 3. 사용자 정보 조회
    @Transactional(readOnly = true)
    public List<WbUserDTO> getUserInfo(Authentication authentication) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return wbUserService.getUserInfo(userId);
    }

    // 4. 사용자 정보 변경
    @Transactional
    public String updateUserInfo(WbUserUpdateDTO wbUserUpdateDTO) {
        return wbUserService.updateUserInfo(wbUserUpdateDTO);
    }

    public int getJobPoint(String userId) {
        return wbUserService.getJobPoint(userId);
    }
}