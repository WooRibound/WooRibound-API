package com.wooribound.domain.knowhowreported;

import com.wooribound.domain.knowhow.Knowhow;
import com.wooribound.domain.wbuser.WbUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "knowhow_reported")
@AllArgsConstructor
@Entity
@SequenceGenerator(
        name = "knowhow_reported_seq_generator",
        sequenceName = "knowhow_reported_SEQ",
        allocationSize = 1
)
public class KnowhowReported {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "knowhow_reported_seq_generator"
    )
    @Column(name = "reported_id")
    private Long reportedId;

    @Column(name = "reported_date", nullable = false)
    private Date reportedDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private WbUser wbUser;

    @ManyToOne
    @JoinColumn(name = "knowhow_id", nullable = false)
    private Knowhow knowhow;
}
