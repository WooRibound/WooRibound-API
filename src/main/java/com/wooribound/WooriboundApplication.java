package com.wooribound;

import jakarta.annotation.PostConstruct;
import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WooriboundApplication {

  public static void main(String[] args) {
    SpringApplication.run(WooriboundApplication.class, args);
  }
  @PostConstruct
  public void init() {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
  }

}
