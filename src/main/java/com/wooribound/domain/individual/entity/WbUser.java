package com.wooribound.domain.individual.entity;

import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;
import com.wooribound.global.domain.employment.Employment;
import com.wooribound.global.domain.notification.Notification;
import com.wooribound.global.domain.userapply.UserApply;
import com.wooribound.global.domain.useredu.UserEdu;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

  @Column(name = "provider_id", nullable = false, length = 20)  // NOT NULL 제약 조건
  private String providerId;

  @Column(name = "name", nullable = false, length = 20)
  private String name;

  @Column(name = "birth", nullable = false)  // NOT NULL 제약 조건
  private Date birth;

  @Column(name = "phone", nullable = false, length = 20)
  private String phone;

  @Column(name = "gender", nullable = false, length = 4)
  @Enumerated(value = EnumType.STRING)
  private Gender gender;

  @Column(name = "exjob_chk", columnDefinition = "VARCHAR2(1) DEFAULT 'N'", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private YN exjobChk = YN.N;

  @Column(name = "interest_chk", columnDefinition = "VARCHAR2(1) DEFAULT 'N'", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private YN interestChk = YN.N;

  @Column(name = "addr_city", nullable = false, length = 20)
  private String addrCity;

  @Column(name = "addr_province", nullable = false, length = 20)
  private String addrProvince;

  @Column(name = "job_point", nullable = false, columnDefinition = "NUMBER DEFAULT 0")
  private int jobPoint = 0;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "job_interest", nullable = false, columnDefinition = "VARCHAR2(1) DEFAULT 'N'")
  private YN jobInterest = YN.N;

  @Column(name = "created_at", nullable = false)  // NOT NULL 제약 조건
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "is_deleted", nullable = false, columnDefinition = "VARCHAR2(1) DEFAULT 'N'", length = 10)  // NOT NULL 제약 조건
  private YN isDeleted = YN.N;

  @OneToOne(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private Resume resume;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<UserApply> userApplies;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<Employment> employments;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<UserEdu> userEdues;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<InterestJob> interestJobs;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<WorkHistory> workHistories;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<Notification> notifications;
}