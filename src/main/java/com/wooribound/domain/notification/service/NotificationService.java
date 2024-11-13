package com.wooribound.domain.notification.service;

import com.wooribound.domain.notification.dto.NotificationDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getNotifications(Authentication authentication);

    String readNotification (Authentication authentication, Long notiId);

}
