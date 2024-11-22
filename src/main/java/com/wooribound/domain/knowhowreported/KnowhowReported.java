package com.wooribound.domain.knowhowreported;

import com.wooribound.domain.knowhow.Knowhow;
import com.wooribound.domain.wbuser.WbUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "knowhow_reported")
@AllArgsConstructor
@Entity
public class KnowhowReported {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reported_id")
    private Long reportedId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private WbUser wbUser;

    @ManyToOne
    @JoinColumn(name = "knowhow_id", nullable = false)
    private Knowhow knowhow;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
