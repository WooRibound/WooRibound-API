package com.wooribound.api.individual.controller;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.api.individual.facade.WbUserInfoFacade;
import com.wooribound.domain.userapply.DTO.WbUserApplyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/individualuser/info")
public class WbUserInfoController {

    private final WbUserInfoFacade wbUserInfoFacade;

    // 1. 지원 공고 조회
    @GetMapping("/jobposting/myapply")
    public List<WbUserApplyDTO> getUserApplyList(@RequestParam String user_id) {
        return wbUserInfoFacade.getUserApplyList(user_id);
    }

    // 2. 지원 공고 취소
    @PostMapping("/apply/cancel")
    public String cancelUserApply(@RequestBody UserApplyDTO userApplyDTO) {
        return wbUserInfoFacade.cancelUserApply(userApplyDTO);
    }

}
