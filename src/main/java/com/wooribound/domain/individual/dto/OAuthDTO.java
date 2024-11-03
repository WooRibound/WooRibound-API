package com.wooribound.domain.individual.dto;

import com.wooribound.global.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OAuthDTO {
  private String id;
  private String name;
}
