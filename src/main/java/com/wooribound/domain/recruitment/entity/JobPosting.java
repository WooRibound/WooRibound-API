package com.wooribound.domain.recruitment.entity;

import com.wooribound.global.constant.PostState;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "job_postings")
@AllArgsConstructor
@Entity
public class JobPosting {
  @Id
  private Long postId;
  private String entId;
  private String postTitle;
  private String postImg;
  private Date startDate;
  private Date endDate;
  private PostState postState;
}

