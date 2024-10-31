package com.wooribound.domain.education.entity;

import com.wooribound.global.entity.UserEdu;
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
  private String eduName;
  private String eduImg;
  private Date startDate;
  private Date endDate;
  private String eduJob;
  private String eduHost;

  @OneToMany(mappedBy = "education", fetch = FetchType.LAZY)
  private List<UserEdu> userEdu;
}

