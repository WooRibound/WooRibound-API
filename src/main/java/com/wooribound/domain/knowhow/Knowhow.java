package com.wooribound.domain.knowhow;

import com.wooribound.domain.knowhowreported.KnowhowReported;
import com.wooribound.domain.wbuser.WbUser;
import jakarta.persistence.*;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "knowhow")
@AllArgsConstructor
@Entity
public class Knowhow {
    @Id
    @Column(name = "knowhow_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long knowhowId;

    @Column(name = "knowhow_job", length = 30, nullable = false)
    private String knowhowJob;

    @Column(name = "knowhow_title", length = 100, nullable = false)
    private String knowhowTitle;

    @Column(name = "knowhow_content", length = 4000, nullable = false)
    private String knowhowContent;

    @Column(name = "upload_date", nullable = false)
    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private WbUser wbUser;

    @OneToMany(mappedBy = "knowhow", fetch = FetchType.LAZY, cascade = CascadeType.ALL)  // cascade 추가
    private List<KnowhowReported> knowhowReportedList;

}
