package com.wooribound.domain.userapply.Service;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.domain.userapply.dto.WbUserApplyDTO;

import java.util.List;

public interface UserApplyService {
    // 1. 공고 지원
    String createUserApply(String userId, Long postId);

    WbUserApplyDTO getUserApplyDetail(String userId, Long applyId);

    // 2. 지원 공고 조회
    List<WbUserApplyDTO> getUserApplyList(String userId);

    // 3. 지원 공고 취소
    String cancelUserApply(String userId, Long applyId);
}
