package com.wooribound.domain.corporate.entity;

import com.wooribound.domain.recruitment.entity.JobPosting;
import com.wooribound.global.constant.YN;
import com.wooribound.global.entity.Employment;
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
  private String regNum;
  private String entPwd;
  private String entName;
  private String entField;
  private String entSize;
  private String ceoName;
  private String revenue;
  private String entAddr;
  private Date createdAt;
  private Date updatedAt;
  @Enumerated(value = EnumType.STRING)
  private YN isDeleted;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "ent_id")
  private List<Employment> employments;

  @OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
  private List<JobPosting> jobPostings;
}

