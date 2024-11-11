package com.wooribound.domain.enterprise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class AdminPendingEnterpriseDTO {
    private String entId;
    private String entName;
    private String entField;
    private Date createdAt;
    private Date deleteRequestedAt;
}
