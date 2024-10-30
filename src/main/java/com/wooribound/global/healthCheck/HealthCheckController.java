package com.wooribound.global.healthCheck;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "HealthCheck", description = "서비스 활성 상태 파악에 필요한 api입니다.")
public class HealthCheckController {


  @GetMapping("/")
  @Operation(summary = "서비스 활성 상태 파악", description = "서비스 활성 상태 파악을 위한 api입니다.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Health Check Success")
  })
  public String healthCheck(){
    return "Health Check Success";
  }
}

