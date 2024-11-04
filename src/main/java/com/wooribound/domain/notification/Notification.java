package com.wooribound.domain.notification;


import com.wooribound.domain.wbuser.WbUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
  @GeneratedValue(
      strategy= GenerationType.AUTO,
      generator = "notification_seq_generator"
  )
  @Column(name = "noti_id")
  private Long notiId;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private WbUser wbUser;

  @Column(name = "notice", nullable = false, length = 200)
  private String notice;
}

