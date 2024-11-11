package com.wooribound.domain.notification.service;

import com.wooribound.domain.notification.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getNotifications(String userId);

    String getNotificationDetail(long notiId);
}
