package com.wooribound.domain.notification.service;

import com.wooribound.domain.notification.Notification;
import com.wooribound.domain.notification.NotificationRepository;
import com.wooribound.domain.notification.dto.NotificationDTO;
import com.wooribound.global.constant.YN;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<NotificationDTO> getNotifications(String userId) {
        // userId에 해당하는 모든 알림 조회 후 DTO로 변환
        return notificationRepository.findByUserId(userId).stream()
                .map(notification -> NotificationDTO.builder()
                        .notiId(Math.toIntExact(notification.getNotiId()))
                        .notice(notification.getNotice())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public String getNotificationDetail(long notiId) {
        // 알림 상세 조회 및 is_confirmed를 Y로 변경
        Notification notification = notificationRepository.findByNotiId(notiId)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found with id: " + notiId));

        // is_confirmed를 Y로 변경
        notification.setIsConfirmed(YN.Y);
        notificationRepository.save(notification);

        return notification.getNotice();
    }
}