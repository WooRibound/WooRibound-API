package com.wooribound.domain.corporate.entity;

import com.wooribound.global.constant.YN;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "enterprise")
@AllArgsConstructor
@Entity
public class enterprise {
  @Id
  private String entId;
  private String regNum;
  private String entPwd;
  private String entName;
  private String field;
  private String size;
  private String ceoName;
  private String revenue;
  private String entAddr;
  private Date createdAt;
  private Date updatedAt;
  private YN isDeleted;

}

