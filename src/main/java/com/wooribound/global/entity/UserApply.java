package com.wooribound.global.entity;


import com.wooribound.global.constant.ApplyResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "user_apply")
@AllArgsConstructor
@Entity
public class UserApply {
  @Id
  private Long applyId;
  private String postId;
  private String userId;
  private String entId;
  private ApplyResult result;
  private Date applyDate;
}
