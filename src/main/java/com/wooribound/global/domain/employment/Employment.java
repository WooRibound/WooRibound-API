package com.wooribound.global.domain.employment;

import com.wooribound.domain.corporate.entity.Enterprise;
import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.global.constant.YN;
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
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "employment")
@AllArgsConstructor
@Entity
@SequenceGenerator(
    name = "employment_seq_generator",
    sequenceName = "employment_SEQ",
    allocationSize = 1
)
public class Employment {
  @Id
  @GeneratedValue(
      strategy= GenerationType.AUTO,
      generator = "employment_seq_generator"
  )
  @Column(name = "emp_id")
  private Long empId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private WbUser wbUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ent_id", nullable = false)
  private Enterprise enterprise;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "emp_state", nullable = false)
  private YN empState;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "emp_recomm")
  private YN empRecomm;

  @Column(name = "hire_date", nullable = false)
  private Date hireDate;
}
