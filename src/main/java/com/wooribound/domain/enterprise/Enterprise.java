package com.wooribound.domain.enterprise;

import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.global.constant.EntSize;
import com.wooribound.domain.employment.Employment;
import com.wooribound.global.constant.YNP;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
  @Column(name = "ent_id",  columnDefinition = "VARCHAR(20) BINARY")
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
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "delete_requested_at")
  private LocalDateTime deleteRequestedAt;

  @Enumerated(EnumType.STRING)
  @Column(name = "is_deleted", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'") // database default 설정 (jpql 사용에 대비)
  private YNP isDeleted = YNP.N; // entity 필드 기본값 설정 (jpa 함수 사용을 통한 쿼리 생성 대비)

  @OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
  private List<Employment> employments;

  @OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
  private List<JobPosting> jobPostings;

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
  }

  // @PreUpdate는 엔티티가 업데이트될 때 호출됩니다.
  @PreUpdate
  public void preUpdate() {
    updatedAt = LocalDateTime.now();
  }
}

