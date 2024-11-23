package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminKnowhowReqDTO;
import com.wooribound.api.admin.facade.AdminKnowhowFacade;
import com.wooribound.domain.knowhow.dto.AdminKnowhowDTO;
import com.wooribound.domain.knowhow.dto.AdminKnowhowDetailDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "지혜 관리 관련 API", description = "서비스 관리자 기능 중 지혜 관리 기능 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/knowhow")
public class AdminKnowhowController {
    private final AdminKnowhowFacade adminKnowhowFacade;

    @Operation(summary = "지혜 목록 조회", description = "지혜 목록 조회")
    @GetMapping
    public List<AdminKnowhowDTO> getAllKnowhows(@ModelAttribute AdminKnowhowReqDTO adminKnowhowReqDTO) {
        return adminKnowhowFacade.getAllKnowhows(adminKnowhowReqDTO);
    }

    @Operation(summary = "지혜 상세 정보 조회", description = "지혜 상세 정보 조회")
    @GetMapping("/detail")
    public AdminKnowhowDetailDTO getKnowhowDetail(@RequestParam Long knowhowId) {
        return adminKnowhowFacade.getKnowhowDetail(knowhowId);
    }

    @Operation(summary = "지혜 삭제", description = "지혜 삭제")
    @DeleteMapping("/delete")
    public String deleteKnowhow(@RequestParam Long knowhowId) {
        return adminKnowhowFacade.deleteKnowhow(knowhowId);
    }
}
