package com.wooribound.domain.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    @Query("SELECT n FROM Notification n WHERE n.wbUser.userId = :userId")
    List<Notification> findByUserId(@Param("userId") String userId);

    Optional<Notification> findByNotiId(long notiId);
}
