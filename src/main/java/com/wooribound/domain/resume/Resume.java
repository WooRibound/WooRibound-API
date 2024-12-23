package com.wooribound.domain.resume;

import com.wooribound.domain.wbuser.WbUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Builder
@Table(name = "resume")
@AllArgsConstructor
@Entity
public class Resume {
    @Id
    @Column(name = "resume_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private WbUser wbUser;

    @Column(name = "user_img", nullable = false, length = 200)  // NOT NULL 제약 조건
    private String userImg;

    @Column(name = "resume_email", nullable = false, length = 50)  // NOT NULL 제약 조건
    private String resumeEmail;

    @Column(name = "user_intro", nullable = false, length = 200)  // NOT NULL 제약 조건
    private String userIntro;
}


