package com.wooribound.domain.individual.entity;

import jakarta.persistence.Id;

public class resume {
    @Id
    private Long resumeId;
    private String userId;
    private String userImg;
    private String userEmail;
    private String userIntro;
}
