package com.wooribound.domain.individual.entity;

import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;
import com.wooribound.global.entity.Employment;
import com.wooribound.global.entity.Notification;
import com.wooribound.global.entity.UserApply;
import com.wooribound.global.entity.UserEdu;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

  @Column(nullable = false)  // NOT NULL 제약 조건
  private String providerId;

  @Column(nullable = false)  // NOT NULL 제약 조건
  private String name;

  @Column(nullable = false)  // NOT NULL 제약 조건
  private Date birth;

  @Column(nullable = false)  // NOT NULL 제약 조건
  private String phone;

  @Column(nullable = false)  // NOT NULL 제약 조건
  private Gender gender;

  @Column(nullable = false)  // NOT NULL 제약 조건
  private String jobEx;

  @Column(nullable = false)  // NOT NULL 제약 조건
  private String addrCity;

  @Column(nullable = false)  // NOT NULL 제약 조건
  private String addrProvince;

  @Column(nullable = false, columnDefinition = "NUMBER DEFAULT 0")
  private int jobPoint = 0;

  @Enumerated(value = EnumType.STRING)
  @Column(nullable = false, columnDefinition = "VARCHAR2(1) DEFAULT 'N'")
  private YN jobInterest = YN.N;

  @Column(nullable = false)  // NOT NULL 제약 조건
  private Date createdAt;

  private Date updatedAt;

  @Enumerated(value = EnumType.STRING)
  @Column(nullable = false, columnDefinition = "VARCHAR2(1) DEFAULT 'N'")  // NOT NULL 제약 조건
  private YN isDeleted = YN.N;




  @OneToOne(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private Resume resume;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<UserApply> userApplies;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  private List<Employment> employments;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<UserEdu> userEdues;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<InterestJob> interestJobs;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<WorkHistory> workHistories;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<Notification> notifications;
}

