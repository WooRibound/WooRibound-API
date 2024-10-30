package com.wooribound.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openApi(){
    return new OpenAPI()
        .info(apiInfo());
  }

  /*

      @Bean
      public OpenAPI openApi(){
          return new OpenAPI().addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
              .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
              .info(apiInfo());
      }

      private SecurityScheme createAPIKeyScheme() {
          return new SecurityScheme().type(SecurityScheme.Type.HTTP)
              .bearerFormat("JWT")
              .scheme("bearer");
      }
  */
  private Info apiInfo() {
    return new Info()
        .title("Wooribound API 명세서")
        .description("Wooribound API 명세서입니다.")
        .version("1.0.0");
  }

}