package com.wooribound.domain.education.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "education")
@AllArgsConstructor
@Entity
public class education {
  @Id
  private Long eduId;
  private String eduName;
  private String eduImg;
  private Date startDate;
  private Date endDate;
  private String eduJob;
  private String eduHost;

}

