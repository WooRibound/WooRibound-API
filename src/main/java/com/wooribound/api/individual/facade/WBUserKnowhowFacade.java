package com.wooribound.api.individual.facade;

import com.wooribound.domain.knowhow.dto.WbUserKnowhowDTO;
import com.wooribound.domain.knowhow.service.WbUserKnowhowService;
import com.wooribound.domain.knowhowreported.service.KnowhowReportedService;
import com.wooribound.global.util.AuthenticateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WBUserKnowhowFacade {

    private final AuthenticateUtil authenticateUtil;
    private final WbUserKnowhowService wbUserKnowhowService;
    private final KnowhowReportedService knowhowReportedService;

    @Transactional(readOnly = true)
    public List<WbUserKnowhowDTO> getAllShareKnowhows(Authentication authentication, String knowhowTitle, String knowhowJob) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return wbUserKnowhowService.getAllShareKnowhows(userId, knowhowTitle, knowhowJob);
    }

    @Transactional
    public Long deleteShareKnowhow(Authentication authentication, Long knowhowId) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return wbUserKnowhowService.deleteShareKnowhow(userId, knowhowId);
    }

    @Transactional
    public Long createShareKnowhow(Authentication authentication, WbUserKnowhowDTO wbUserKnowhowDTO) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return wbUserKnowhowService.createShareKnowhow(userId, wbUserKnowhowDTO);
    }

    @Transactional(readOnly = true)
    public List<WbUserKnowhowDTO> getAllExploreKnowhows (String knowhowTitle, String knowhowJob) {
        return wbUserKnowhowService.getAllExploreKnowhows(knowhowTitle, knowhowJob);
    }

    @Transactional(readOnly = true)
    public WbUserKnowhowDTO getShareKnowhowDetail(Long knowhowId) {
        return wbUserKnowhowService.getShareKnowhowDetail(knowhowId);
    }

    @Transactional
    public String reportKnowhow (Authentication authentication, Long knowhowId) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return knowhowReportedService.reportKnowhow(userId, knowhowId);
    }

}
