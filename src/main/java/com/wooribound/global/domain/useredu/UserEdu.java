package com.wooribound.global.domain.useredu;

import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.global.constant.YN;
import com.wooribound.global.domain.education.Education;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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
@SequenceGenerator(
    name = "user_edu_generator",
    sequenceName = "user_edu_SEQ",
    allocationSize = 1
)
public class UserEdu {
  @Id
  @GeneratedValue(
      strategy= GenerationType.AUTO,
      generator = "user_edu_generator"
  )
  @Column(name = "useredu_id")
  private Long usereduId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private WbUser wbUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "edu_id", nullable = false)
  private Education education;

  @Column(name = "regist_date", nullable = false)
  private Date registDate;
  
  @Column(name = "comp_state", nullable = false, columnDefinition = "VARCHAR2(1) DEFAULT 'N'")
  @Enumerated(value = EnumType.STRING)
  private YN compState = YN.N;
}
