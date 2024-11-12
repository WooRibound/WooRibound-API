package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminWbUserReqDTO;
import com.wooribound.api.admin.facade.AdminIndividualFacade;
import com.wooribound.domain.resume.dto.ResumeDetailDTO;
import com.wooribound.domain.wbuser.dto.AdminIndividualDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/individual")
public class AdminIndividualController {

    private final AdminIndividualFacade adminIndividualFacade;

    @GetMapping
    public List<AdminIndividualDTO> getWbUsers(@ModelAttribute AdminWbUserReqDTO adminWbUserReqDTO) {
        return adminIndividualFacade.getWbUsers(adminWbUserReqDTO);
    }

    @GetMapping("/detail")
    public ResumeDetailDTO getWbUserResume(@RequestParam String userId) {
        return adminIndividualFacade.getWbUserResume(userId);
    }
}
