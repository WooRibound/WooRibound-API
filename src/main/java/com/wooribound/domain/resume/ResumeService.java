package com.wooribound.domain.resume;

import com.wooribound.domain.resume.dto.ResumeDTO;
import com.wooribound.domain.resume.dto.ResumeDetailDTO;

import java.util.List;

public interface ResumeService {
    ResumeDTO getResume(String userId);
    String registerResume(ResumeDTO resumeDTO);
    String updateResume(ResumeDTO resumeDTO);

    // 이력서 전체 정보 가져오는 함수
    ResumeDetailDTO getWbUserResume(String userId);
}
