package com.wooribound.domain.notification.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    private int notiId;
    private String notice;
}
