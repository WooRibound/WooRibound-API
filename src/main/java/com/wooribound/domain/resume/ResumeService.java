package com.wooribound.domain.resume;

import com.wooribound.domain.resume.dto.ResumeDTO;

import java.util.List;

public interface ResumeService {
    ResumeDTO getResume(String userId);
    String registerResume(ResumeDTO resumeDTO);
    String updateResume(ResumeDTO resumeDTO);
}
