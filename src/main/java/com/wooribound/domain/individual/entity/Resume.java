package com.wooribound.domain.individual.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Resume {
    @Id
    private Long resumeId;
    private String userId;
    private String userImg;
    private String userEmail;
    private String userIntro;

    @OneToOne
    @JoinColumn(name = "user_id")
    private WbUser wbUser;
}
