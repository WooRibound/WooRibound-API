package com.wooribound.domain.recruitment.entity;

import com.wooribound.domain.corporate.entity.Enterprise;
import com.wooribound.global.constant.PostState;
import com.wooribound.global.entity.UserApply;
import jakarta.persistence.*;

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
  @Column(name = "post_id")
  private Long postId;

  @Column(name = "post_title", nullable = false, length = 50)
  private String postTitle;

  @Column(name = "post_img", nullable = false, length = 255)
  private String postImg;

  @Column(name = "start_date", nullable = false)
  private Date startDate;

  @Column(name = "end_date", nullable = false)
  private Date endDate;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "post_state", nullable = false)
  private PostState postState;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ent_id")
  private Enterprise enterprise;

  @OneToMany(mappedBy = "jobPosting",fetch = FetchType.LAZY)
  private List<UserApply> userApply;
}