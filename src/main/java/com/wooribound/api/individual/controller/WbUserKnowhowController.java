package com.wooribound.api.individual.controller;

import com.wooribound.api.individual.dto.KnowhowReportReqDTO;
import com.wooribound.api.individual.facade.WBUserKnowhowFacade;
import com.wooribound.domain.knowhow.dto.WbUserKnowhowDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@Tag(name = "지혜 나눔/등록 API", description = "개인회원 서비스 중 지혜 나눔/등록 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/individual/knowhow")
public class WbUserKnowhowController {

    private final WBUserKnowhowFacade wbUserKnowhowFacade;

    @Operation(summary = "지혜 나눔 전체 목록 조회(메인)", description = "지혜 나눔 전체 목록 조회(메인)")
    @GetMapping("/main/share")
    public ResponseEntity getFirst5ShareKnowhows()
    {
        return ResponseEntity.ok().body(wbUserKnowhowFacade.getLatest4ShareKnowhows());
    }

    @Operation(summary = "지혜 나눔 전체 목록 조회", description = "지혜 나눔 전체 목록 조회")
    @GetMapping("/share")
    public ResponseEntity getAllShareKnowhows(Authentication authentication,
                                              @RequestParam(value = "knowhowTitle") String knowhowTitle,
                                              @RequestParam(value = "knowhowJob") String knowhowJob)
    {
        return ResponseEntity.ok().body(wbUserKnowhowFacade.getAllShareKnowhows(authentication, knowhowTitle, knowhowJob));
    }

    @Operation(summary = "지헤 나눔 삭제",  description = "지헤 나눔 삭제")
    @DeleteMapping("/share/delete")
    public ResponseEntity deleteShareKnowhow(Authentication authentication, @RequestParam("knowhowId") Long knowhowId) {
        return ResponseEntity.ok().body(wbUserKnowhowFacade.deleteShareKnowhow(authentication, knowhowId));
    }

    @Operation(summary = "지헤 나눔 등록",  description = "지헤 나눔 등록")
    @PostMapping("/share/register")
    public ResponseEntity createShareKnowhow(Authentication authentication,
                                             @RequestBody WbUserKnowhowDTO wbUserKnowhowDTO)
    {
        wbUserKnowhowFacade.createShareKnowhow(authentication, wbUserKnowhowDTO);
        return ResponseEntity.ok().body("등록이 완료 되었습니다.");
    }

    @Operation(summary = "지혜 탐색 전체 목록 조회", description = "지혜 탐색 전체 목록 조회")
    @GetMapping("/explore")
    public ResponseEntity getAllExploreKnowhows(@RequestParam(value = "knowhowTitle") String knowhowTitle,
                                                @RequestParam(value = "knowhowJob") String knowhowJob)
    {
        return ResponseEntity.ok().body(wbUserKnowhowFacade.getAllExploreKnowhows(knowhowTitle, knowhowJob));
    }

    @Operation(summary = "지혜 나눔/탐색 상세 조회", description = "지혜 나눔/탐색 상세 조회")
    @GetMapping("/detail")
    public ResponseEntity getShareKnowhowDetail(@RequestParam("knowhowId") Long knowhowId)
    {
        return  ResponseEntity.ok().body(wbUserKnowhowFacade.getShareKnowhowDetail(knowhowId));
    }

    @Operation(summary = "지혜 나눔 신고하기", description = "지혜 나눔 신고하기")
    @PostMapping("/report")
    public ResponseEntity reportKnowhow(Authentication authentication, @RequestBody KnowhowReportReqDTO knowhowReportReqDTO) {
        return ResponseEntity.ok().body(wbUserKnowhowFacade.reportKnowhow(authentication, knowhowReportReqDTO.getKnowhowId()));
    }
}
