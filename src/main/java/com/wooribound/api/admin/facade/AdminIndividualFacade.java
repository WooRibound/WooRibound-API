package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminWbUserReqDTO;
import com.wooribound.domain.resume.ResumeService;
import com.wooribound.domain.resume.dto.ResumeDetailDTO;
import com.wooribound.domain.wbuser.service.AdminWbUserService;
import com.wooribound.domain.wbuser.dto.AdminIndividualDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AdminIndividualFacade {

    private final AdminWbUserService adminWbUserService;
    private final ResumeService resumeService;

    @Transactional(readOnly = true)
    public List<AdminIndividualDTO> getWbUsers(AdminWbUserReqDTO adminWbUserReqDTO) {
        return adminWbUserService.getWbUsers(adminWbUserReqDTO);
    }

    @Transactional(readOnly = true)
    public ResumeDetailDTO getWbUserResume(String userId) {
        return resumeService.getWbUserResume(userId);
    }
}
