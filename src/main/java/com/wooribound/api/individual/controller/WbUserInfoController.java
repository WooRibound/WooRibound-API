package com.wooribound.api.individual.controller;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserUpdateDTO;
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
    public List<WbUserApplyDTO> getUserApplyList(@ModelAttribute UserApplyDTO userApplyDTO) {
        return wbUserInfoFacade.getUserApplyList(userApplyDTO);
    }

    // 2. 지원 공고 취소
    @PostMapping("/apply/cancel")
    public String cancelUserApply(@RequestBody UserApplyDTO userApplyDTO) {
        return wbUserInfoFacade.cancelUserApply(userApplyDTO);
    }

    // 3. 사용자 정보 조회
    @GetMapping("")
    public List<WbUserDTO> getUserInfo(@RequestParam("user_id") String userId) {
        return wbUserInfoFacade.getUserInfo(userId);
    }

    // 4. 사용자 정보 수정
    @PostMapping("/update")
    public String updateUserInfo(@RequestBody WbUserUpdateDTO wbUserUpdateDTO) {
        return wbUserInfoFacade.updateUserInfo(wbUserUpdateDTO);
    }

    // 5. 우바 점수 조회
    @GetMapping("/wbpoint")
    public int getJobPoint(@RequestParam("user_id") String userId) {
        return wbUserInfoFacade.getJobPoint(userId);
    }
}
