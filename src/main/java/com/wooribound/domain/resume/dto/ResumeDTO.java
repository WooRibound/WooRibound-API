package com.wooribound.domain.resume.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ResumeDTO {
    private String userId;
    private String userName;
    private String userPhone;
    private String userImg;
    private String resumeEmail;
    private String userIntro;
}
