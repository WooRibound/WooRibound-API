package com.wooribound.domain.notification.dto;


import com.wooribound.global.constant.YN;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationDTO {
    private Long notiId;
    private String notice;
    private YN isConfirmed;
    private Date createdAt;
}
