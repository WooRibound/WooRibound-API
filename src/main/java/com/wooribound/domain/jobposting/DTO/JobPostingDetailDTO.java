package com.wooribound.domain.jobposting.DTO;

import com.wooribound.global.constant.PostState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class JobPostingDetailDTO {
    private String postTitle;      // 공고 제목
    private String entName;        // 기업 이름
    private String postImg;        // 공고 이미지
    private Date startDate;        // 공고 시작 날짜
    private Date endDate;          // 공고 종료 날짜
    private PostState postState;   // 공고 상태
    private String jobName;        // 직무 이름
    private String entAddr1;       // 기업 주소 1
    private String entAddr2;       // 기업 주소 2
    private int applicantCount;    // 지원자 수
}