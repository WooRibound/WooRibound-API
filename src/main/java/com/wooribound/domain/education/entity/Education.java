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

  @Column(name = "edu_name", length = 50, nullable = false)
  private String eduName;

  @Column(name = "edu_img", length = 200, nullable = false)
  private String eduImg;

  @Column(name = "start_date", nullable = false)
  private Date startDate;

  @Column(name = "end_date", nullable = false)
  private Date endDate;

  @Column(name = "edu_job", length = 30, nullable = false)
  private String eduJob;

  @Column(name = "edu_host", length = 50, nullable = false)
  private String eduHost;

  @OneToMany(mappedBy = "education", fetch = FetchType.LAZY)
  private List<UserEdu> userEdu;
}

