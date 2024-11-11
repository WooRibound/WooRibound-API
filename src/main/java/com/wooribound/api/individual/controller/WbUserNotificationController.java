package com.wooribound.api.individual.controller;

import com.wooribound.domain.notification.dto.NotificationDTO;
import com.wooribound.domain.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/individual/notifications")
public class WbUserNotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public List<NotificationDTO> getNotifications(@RequestParam String userId) {
        return notificationService.getNotifications(userId);
    }

    @GetMapping("/detail")
    public String getNotificationDetail(@RequestParam long notiId) {
        return notificationService.getNotificationDetail(notiId);
    }
}
