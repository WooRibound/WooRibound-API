package com.wooribound.api.individual.controller;

import com.wooribound.domain.notification.dto.NotificationDTO;
import com.wooribound.domain.notification.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "알림 메세지 API", description = "개인회원 서비스 중 알림 메세지 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/individual/notifications")
public class WbUserNotificationController {

    private final NotificationService notificationService;

    @Operation(summary = "알림 메세지 전체 목록 조회", description = "알림 메세지 나눔 전체 목록 조회")
    @GetMapping
    public ResponseEntity getNotifications(Authentication authentication) {
        return ResponseEntity.ok().body(notificationService.getNotifications(authentication));
    }

    @Operation(summary = "알림 메세지 읽음 표시 업데이트", description = "알림 메세지 읽음 표시 업데이트")
    @PutMapping("/read")
    public ResponseEntity readNotification(Authentication authentication, @RequestParam(value = "notiId") Long notiId) {
        return ResponseEntity.ok().body(notificationService.readNotification(authentication, notiId));
    }

}
