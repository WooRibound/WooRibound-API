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
    @JoinColumn(name = "user_id", nullable = false)
    private WbUser wbUser;
    @Column(nullable = false)  // NOT NULL 제약 조건
    private String userImg;
    @Column(nullable = false)  // NOT NULL 제약 조건
    private String userEmail;
    @Column(nullable = false)  // NOT NULL 제약 조건
    private String userIntro;
}
