package com.wooribound.domain.corporate.entity;

import com.wooribound.domain.recruitment.entity.JobPosting;
import com.wooribound.global.constant.YN;
import com.wooribound.global.entity.Employment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.*;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "enterprise")
@AllArgsConstructor
@Entity
public class Enterprise {
  @Id
  private String entId;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String regNum;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String entPwd;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String entName;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String entField;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String entSize;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String ceoName;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String revenue;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String entAddr;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private Date createdAt;
  private Date updatedAt;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, columnDefinition = "VARCHAR2(1) DEFAULT 'N'") // database default 설정 (jpql 사용에 대비)
  private YN isDeleted = YN.N; // entity 필드 기본값 설정 (jpa 함수 사용을 통한 쿼리 생성 대비)

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "ent_id", nullable = false)
  private List<Employment> employments;

  @OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
  private List<JobPosting> jobPostings;
}

