package com.wooribound.domain.resume;

import com.wooribound.domain.resume.dto.ResumeDTO;
import com.wooribound.domain.resume.dto.ResumeDetailDTO;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface ResumeService {
    ResumeDTO getResume(Authentication authentication);
    ResumeDTO registerResume(Authentication authentication, MultipartFile userImg, String resumeEmail, String userIntro) throws IOException;
    ResumeDTO updateResume(Authentication authentication, MultipartFile userImg, String resumeEmail, String userIntro) throws IOException;

    // 이력서 전체 정보 가져오는 함수
    ResumeDetailDTO getWbUserResume(String userId);
}
