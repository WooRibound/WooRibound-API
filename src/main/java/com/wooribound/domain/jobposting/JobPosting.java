package com.wooribound.domain.jobposting;

import com.wooribound.domain.enterprise.Enterprise;
import com.wooribound.domain.job.Job;
import com.wooribound.domain.userapply.UserApply;
import com.wooribound.global.constant.YN;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "job_posting")
@AllArgsConstructor
@Entity
@SequenceGenerator(
        name = "job_posting_seq_generator",
        sequenceName = "job_posting_SEQ",
        allocationSize = 1
)
public class JobPosting {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "job_posting_seq_generator"
    )
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ent_id", nullable = false)
    private Enterprise enterprise;

    @Column(name = "post_title", nullable = false, length = 50)
    private String postTitle;

    @Column(name = "post_img", nullable = false, length = 255)
    private String postImg;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_deleted", nullable = false, columnDefinition = "VARCHAR2(1) DEFAULT 'N'")
    private YN isDeleted = YN.N;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    @OneToMany(mappedBy = "jobPosting", fetch = FetchType.LAZY)
    private List<UserApply> userApply;
}