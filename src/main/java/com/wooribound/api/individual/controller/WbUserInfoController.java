package com.wooribound.api.individual.controller;

import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserUpdateDTO;
import com.wooribound.api.individual.facade.WbUserInfoFacade;
import com.wooribound.domain.userapply.dto.WbUserApplyDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "지원 현황 / 개인 정보 / 우바 고도 API", description = "개인회원 서비스 중 지원 현황 / 개인 정보 / 우바 고도 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/individualuser/info")
public class WbUserInfoController {

    private final WbUserInfoFacade wbUserInfoFacade;

    @Operation(summary = "지원 현황 조회", description = "지원 현황 조회")
    @GetMapping("/jobposting/myapply")
    public List<WbUserApplyDTO> getUserApplyList(Authentication authentication) {
        return wbUserInfoFacade.getUserApplyList(authentication);
    }

    @Operation(summary = "공고 지원 취소", description = "공고 지원 취소")
    @PostMapping("/apply/cancel")
    public String cancelUserApply(Authentication authentication, @RequestParam("applyId") Long applyId) {
        return wbUserInfoFacade.cancelUserApply(authentication, applyId);
    }

    // 3. 사용자 정보 조회
    @GetMapping("")
    public WbUserDTO getUserInfo(Authentication authentication) {
        return wbUserInfoFacade.getUserInfo(authentication);
    }

    // 4. 사용자 정보 수정
    @PostMapping("/update")
    public WbUserUpdateDTO updateUserInfo(Authentication authentication, @RequestBody WbUserUpdateDTO wbUserUpdateDTO) {
        return wbUserInfoFacade.updateUserInfo(authentication,wbUserUpdateDTO);
    }

    // 5. 우바 점수 조회
    @GetMapping("/wbpoint")
    public int getJobPoint(Authentication authentication) {
        return wbUserInfoFacade.getJobPoint(authentication);
    }
}
