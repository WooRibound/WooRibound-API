package com.wooribound.domain.userapply.Service;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.domain.userapply.dto.WbUserApplyDTO;

import java.util.List;

public interface UserApplyService {
    // 1. 공고 지원
    String createUserApply(UserApplyDTO userApplyDTO);

    // 2. 지원 공고 조회
    List<WbUserApplyDTO> getUserApplyList(UserApplyDTO userApplyDTO);

    // 3. 지원 공고 취소
    String cancelUserApply(UserApplyDTO userApplyDTO);
}
