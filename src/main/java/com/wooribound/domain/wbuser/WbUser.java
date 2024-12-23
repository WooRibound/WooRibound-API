package com.wooribound.domain.wbuser;

import com.wooribound.domain.employment.Employment;
import com.wooribound.domain.interestjob.InterestJob;
import com.wooribound.domain.knowhow.Knowhow;
import com.wooribound.domain.knowhowreported.KnowhowReported;
import com.wooribound.domain.notification.Notification;
import com.wooribound.domain.resume.Resume;
import com.wooribound.domain.userapply.UserApply;
import com.wooribound.domain.workhistory.WorkHistory;
import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Builder
@Table(name = "wb_user")
@AllArgsConstructor
@Entity
public class WbUser {
  @Id
  @Column(name = "user_id")
  private String userId;

  @Column(name = "name", nullable = false, length = 20)
  private String name;

  @Column(name = "birth")
  private Date birth;

  @Column(name = "email", length = 50)
  private String email;

  @Column(name = "phone", length = 20)
  private String phone;

  @Column(name = "gender", nullable = false, length = 4)
  @Enumerated(value = EnumType.STRING)
  private Gender gender;

  @Column(name = "exjob_chk", columnDefinition = "CHAR(1) DEFAULT 'N'")
  @Enumerated(value = EnumType.STRING)
  private YN exjobChk = YN.N;

  @Column(name = "interest_chk", columnDefinition = "CHAR(1) DEFAULT 'N'", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private YN interestChk = YN.N;

  @Column(name = "addr_city", length = 20)
  private String addrCity;

  @Column(name = "addr_province", length = 20)
  private String addrProvince;

  @Column(name = "job_point", nullable = false, columnDefinition = "INT DEFAULT 0")
  private int jobPoint = 0;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "job_interest", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'")
  private YN jobInterest = YN.N;

  @Column(name = "created_at", nullable = false)  // NOT NULL 제약 조건
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "is_deleted", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'", length = 10)  // NOT NULL 제약 조건
  private YN isDeleted = YN.N;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "first_login", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'", length = 1)
  private YN isInfoRegistered = YN.N;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "data_sharing_consent", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'", length = 1)
  private YN dataSharingConsent = YN.N;

  @OneToOne(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private Resume resume;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<UserApply> userApplies;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<Employment> employments;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<InterestJob> interestJobs;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<WorkHistory> workHistories;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<Notification> notifications;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<Knowhow> knowhows;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<KnowhowReported> knowhowReportedList;

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }

  // @PreUpdate는 엔티티가 업데이트될 때 호출됩니다.
  @PreUpdate
  public void preUpdate() {
    updatedAt = LocalDateTime.now();
  }
}