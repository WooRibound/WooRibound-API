package com.wooribound.domain.individual.entity;

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
    private String userImg;
    private String userEmail;
    private String userIntro;
}
