package com.wooribound.domain.admin;

import com.wooribound.domain.admin.dto.AdminDTO;
import com.wooribound.global.constant.AdminType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "admin")
@AllArgsConstructor
@Entity
public class Admin {
  @Id
  @Column(name = "admin_id", length = 20, nullable = false)
  private String adminId;

  @Column(name = "admin_name", length = 10, nullable = false)
  private String adminName;

  @Column(name = "admin_pw", length = 60, nullable = false)
  private String adminPw;

  @Enumerated(value = EnumType.STRING)
  @Column(name  = "admin_type", nullable = false)
  private AdminType adminType;

  // DTO에서 entity로 변환하는 메서드
  public static Admin fromDTO(AdminDTO dto) {
    return Admin.builder()
        .adminId(dto.getAdminId())
        .adminName(dto.getAdminName())
        .adminPw(dto.getAdminPw())
        .adminType(dto.getAdminType())
        .build();
  }

  // 엔티티에서 DTO로 변환하는 메서드
  public AdminDTO toDTO() {
    return AdminDTO.builder()
        .adminId(this.adminId)
        .adminName(this.adminName)
        .adminPw(this.adminPw)
        .adminType(this.adminType)
        .build();
  }

}

