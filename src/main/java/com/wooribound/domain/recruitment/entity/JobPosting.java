package com.wooribound.domain.recruitment.entity;

import com.wooribound.domain.corporate.entity.Enterprise;
import com.wooribound.global.constant.PostState;
import com.wooribound.global.entity.UserApply;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.*;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "job_posting")
@AllArgsConstructor
@Entity
public class JobPosting {
  @Id
  private Long postId;
  private String postTitle;
  private String postImg;
  private Date startDate;
  private Date endDate;
  @Enumerated(value = EnumType.STRING)
  private PostState postState;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ent_id")
  private Enterprise enterprise;

  @OneToMany(mappedBy = "jobPosting",fetch = FetchType.LAZY)
  private List<UserApply> userApply;

}

