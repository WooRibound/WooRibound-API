package com.wooribound.api.individual.facade;

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

    private final AuthenticateUtil authenticateUtil;
    private final UserApplyService userApplyService;
    private final WbUserService wbUserService;

    // 1. 지원 현황 조회
    @Transactional(readOnly = true)
    public List<WbUserApplyDTO> getUserApplyList(Authentication authentication) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return userApplyService.getUserApplyList(userId);
    }

    // 지원 현황 상세 조회
    @Transactional(readOnly = true)
    public WbUserApplyDTO getUserApplyDetail(Authentication authentication, Long applyId) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return userApplyService.getUserApplyDetail(userId, applyId);
    }

    // 2. 지원 공고 취소
    @Transactional
    public String cancelUserApply(Authentication authentication, Long applyId) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return userApplyService.cancelUserApply(userId, applyId);
    }

    // 3. 사용자 정보 조회
    @Transactional(readOnly = true)
    public WbUserDTO getUserInfo(Authentication authentication) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return wbUserService.getUserInfo(userId);
    }

    // 4. 사용자 정보 변경
    @Transactional
    public WbUserUpdateDTO updateUserInfo(Authentication authentication, WbUserUpdateDTO wbUserUpdateDTO) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        wbUserUpdateDTO.setUserId(userId);
        return wbUserService.updateUserInfo(wbUserUpdateDTO);
    }

    public int getJobPoint(Authentication authentication) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return wbUserService.getJobPoint(userId);
    }
}