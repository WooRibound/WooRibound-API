package com.wooribound.domain.notification;


import com.wooribound.domain.userapply.UserApply;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.global.constant.YN;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "notification")
@AllArgsConstructor
@Entity
@SequenceGenerator(
        name = "notification_seq_generator",
        sequenceName = "notification_SEQ",
        allocationSize = 1
)
public class Notification {
    @Id
//    @GeneratedValue(
//            strategy = GenerationType.AUTO,
//            generator = "notification_seq_generator"
//    )
    @Column(name = "noti_id")
    private Long notiId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private WbUser wbUser;

    @Column(name = "notice", nullable = false, length = 200)
    private String notice;

    @Column(name = "is_confirmed", columnDefinition = "VARCHAR2(1) DEFAULT 'N'", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private YN isConfirmed;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "apply_id")
    private UserApply userApply;
}

