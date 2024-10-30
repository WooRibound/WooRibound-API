package com.wooribound.domain.individual.entity;

import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;
import com.wooribound.global.entity.Employment;
import com.wooribound.global.entity.Notification;
import com.wooribound.global.entity.UserApply;
import com.wooribound.global.entity.UserEdu;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private String userId;
  private String providerId;
  private String name;
  private Date birth;
  private String phone;
  private Gender gender;
  private String jobEx;
  private String addrCity;
  private String addrProvince;
  private int jobPoint;
  private YN jobInterest;
  private Date createdAt;
  private Date updatedAt;
  private YN isDeleted;

  @OneToOne(mappedBy = "wbUser", fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private Resume resume;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<UserApply> userApply;

  @OneToMany(mappedBy = "wbUser", fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<Employment> employment;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<UserEdu> userEdu;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<InterestJob> interestJobs;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<WorkHistory> workHistories;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private List<Notification> notification;
}

