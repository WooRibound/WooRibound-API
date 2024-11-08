package com.wooribound.domain.enterprise;

import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.global.constant.EntSize;
import com.wooribound.global.constant.YN;
import com.wooribound.domain.employment.Employment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "enterprise")
@AllArgsConstructor
@Entity
public class Enterprise {
  @Id
  @Column(name = "ent_id")
  private String entId;

  @Column(name = "reg_num", length = 20, nullable = false)
  private String regNum;

  @Column(name =  "ent_pwd", length = 60, nullable = false)
  private String entPwd;

  @Column(name = "ent_name", length = 50, nullable = false)
  private String entName;

  @Column(name = "ent_field", length = 20, nullable = false)
  private String entField;

  @Column(name =  "ent_size", length = 20, nullable = false)
  @Enumerated(EnumType.STRING)
  private EntSize entSize;

  @Column(name = "ceo_name",length = 20, nullable = false)
  private String ceoName;

  @Column(name = "revenue", length = 20, nullable = false)
  private Long revenue;

  @Column(name = "ent_addr1", length = 200, nullable = false)
  private String entAddr1;

  @Column(name = "ent_addr2", length = 200, nullable = false)
  private String entAddr2;

  @Column(name = "created_at", nullable = false)
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @Enumerated(EnumType.STRING)
  @Column(name = "is_deleted", nullable = false, columnDefinition = "VARCHAR2(1) DEFAULT 'N'") // database default 설정 (jpql 사용에 대비)
  private YN isDeleted = YN.N; // entity 필드 기본값 설정 (jpa 함수 사용을 통한 쿼리 생성 대비)

  @OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
  private List<Employment> employments;

  @OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
  private List<JobPosting> jobPostings;
}

