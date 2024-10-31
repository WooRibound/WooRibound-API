package com.wooribound.domain.education.entity;

import com.wooribound.global.entity.UserEdu;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.*;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "education")
@AllArgsConstructor
@Entity
public class Education {
  @Id
  private Long eduId;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String eduName;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String eduImg;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private Date startDate;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private Date endDate;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String eduJob;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String eduHost;

  @OneToMany(mappedBy = "education", fetch = FetchType.LAZY)
  private List<UserEdu> userEdu;
}

