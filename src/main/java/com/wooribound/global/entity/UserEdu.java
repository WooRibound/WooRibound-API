package com.wooribound.global.entity;

import com.wooribound.domain.education.entity.Education;
import jakarta.persistence.*;

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
  private Long usereduId;
  @Column(name = "user_id")
  private String userId;
  private String compState;
  private Date registDate;

  @ManyToOne
  @JoinColumn(name = "edu_id")
  private Education education;
}
