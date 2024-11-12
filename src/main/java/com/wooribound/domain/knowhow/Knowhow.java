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
@SequenceGenerator(
        name = "knowhow_seq_generator",
        sequenceName = "knowhow_SEQ",
        allocationSize = 1
)
public class Knowhow {

  @Id
  @Column(name = "knowhow_id")
  private Long knowhowId;

  @Column(name = "knowhow_job", length = 30, nullable = false)
  private String knowhowJob;

  @Column(name = "knowhow_title", length = 100, nullable = false)
  private String knowhowTitle;

  @Lob
  @Column(name = "knowhow_content", nullable = false)
  private String knowhowContent;

  @Column(name = "upload_date", nullable = false)
  private Date uploadDate;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private WbUser wbUser;
  
  @OneToMany(mappedBy = "knowhow", fetch = FetchType.LAZY, cascade = CascadeType.ALL)  // cascade 추가
  private List<KnowhowReported> knowhowReportedList;

}
