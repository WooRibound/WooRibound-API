package com.wooribound.domain.individual.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "resume")
public class Resume {
    @Id
    private Long resumeId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private WbUser wbUser;

    @Column(name = "user_img", nullable = false, length = 200)  // NOT NULL 제약 조건
    private String userImg;

    @Column(name = "user_email", nullable = false, length = 50)  // NOT NULL 제약 조건
    private String userEmail;

    @Column(name = "user_intro", nullable = false, length = 200)  // NOT NULL 제약 조건
    private String userIntro;}
