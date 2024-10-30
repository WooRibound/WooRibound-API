package com.wooribound.global.entity;


import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.global.constant.ApplyResult;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Lazy;

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


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private WbUser wbUser;

}
