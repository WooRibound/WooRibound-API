package com.wooribound.domain.notification.service;

import com.wooribound.domain.notification.Notification;
import com.wooribound.domain.notification.NotificationRepository;
import com.wooribound.domain.notification.dto.NotificationDTO;
import com.wooribound.global.constant.YN;
import com.wooribound.global.exception.AuthenticationException;
import com.wooribound.global.exception.NotEntityException;
import com.wooribound.global.util.AuthenticateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final AuthenticateUtil authenticateUtil;
    private final NotificationRepository notificationRepository;

    @Override
    public List<NotificationDTO> getNotifications(Authentication authentication) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);

        return notificationRepository.findByUserId(userId).stream()
                .map(notification -> NotificationDTO.builder()
                        .notiId(notification.getNotiId())
                        .notice(notification.getNotice())
                        .isConfirmed(notification.getIsConfirmed())
                        .createdAt(notification.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public String readNotification(Authentication authentication, Long notiId) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        Optional<Notification> byIdNotification = notificationRepository.findById(notiId);

        if (!byIdNotification.isPresent()) {
            throw new NotEntityException();
        }

        if (!byIdNotification.get().getWbUser().getUserId().equals(userId)) {
            throw new AuthenticationException();
        }

        Notification notification = byIdNotification.get();
        notification.setIsConfirmed(YN.Y);
        notificationRepository.save(notification);

        return "Notification updated successfully";
    }

}