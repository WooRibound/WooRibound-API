package com.wooribound.global.entity;

import com.wooribound.domain.education.entity.Education;
import jakarta.persistence.*;
import com.wooribound.global.constant.YN;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
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
@Table(name = "user_edu")
@AllArgsConstructor
@Entity
public class UserEdu {
  @Id
  @Column(name = "useredu_id")
  private Long usereduId;

  @Column(name = "user_id", nullable = false, length = 20)
  private String userId;

  @Column(name = "comp_state", nullable = false, length = 1)
  private String compState;

  @Column(name = "regist_date", nullable = false)
  private Date registDate;
  
  @Column(nullable = false, columnDefinition = "VARCHAR2(1) DEFAULT 'N'")
  private YN compState = YN.N;

  @ManyToOne
  @JoinColumn(name = "edu_id", nullable = false)
  private Education education;
}
