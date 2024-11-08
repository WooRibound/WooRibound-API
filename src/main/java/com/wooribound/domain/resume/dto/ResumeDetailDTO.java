package com.wooribound.domain.resume.dto;

import com.wooribound.domain.job.JobDTO;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDetailDTO {
    private String userName;
    private int jobPoint;
    private String phone;
    private String addrCity;
    private String addrProvince;
    private String userImg;     // resume
    private String resumeEmail; // resume
    private String userIntro;    // resume
    private List<String> jobList;   // 경력 직종 담는 변수
}
