package com.wooribound.api.individual.facade;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.domain.userapply.DTO.WbUserApplyDTO;
import com.wooribound.domain.userapply.Service.UserApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WbUserInfoFacade {

    private final UserApplyService userApplyService;

    // 1. 지원 공고 조회
    public List<WbUserApplyDTO> getUserApplyList(UserApplyDTO userApplyDTO) {
        return userApplyService.getUserApplyList(userApplyDTO);
    }

    // 2. 지원 공고 취소
    public String cancelUserApply(UserApplyDTO userApplyDTO) {
        return userApplyService.cancelUserApply(userApplyDTO);
    }


}

