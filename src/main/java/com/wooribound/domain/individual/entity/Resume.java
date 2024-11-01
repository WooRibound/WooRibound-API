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

    @Column(name = "user_img", length = 200, nullable = false)
    private String userImg;

    @Column(name = "user_email", length = 50, nullable = false)
    private String userEmail;

    @Column(name = "user_intro", length = 200, nullable = false)
    private String userIntro;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private WbUser wbUser;


}
