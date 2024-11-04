package com.wooribound.global.security;

import com.wooribound.api.individual.dto.OAuthDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.global.constant.Gender;
import com.wooribound.global.security.OauthResponseDTO.NaverResponse;
import com.wooribound.global.security.OauthResponseDTO.OAuth2Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WbUserDetailService extends DefaultOAuth2UserService {

  private final WbUserRepository wbUserRepository;
  private static final Logger logger = LoggerFactory.getLogger(WbUserDetailService.class); // Logger 선언

  @Override
  public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
    // 부모 클래스의 메서드를 사용하여 객체를 생성함.
    OAuth2User oAuth2User = super.loadUser(request);

    OAuth2Response oAuth2Response = null;

    // oAuth2User 객체로 부터 응답값을 꺼냄.
    oAuth2Response = new NaverResponse(oAuth2User.getAttributes());

    if (oAuth2Response == null) {
      logger.warn("NaverResponse is null.");// 또는 예외를 던질 수 있습니다.
    }
    System.out.println("네이버로부터 정보 받아오기");
    
    // NaverResponse에서 데이터 추출
    String userId = oAuth2Response.getId();
    String userName = oAuth2Response.getName();
    String userEmail = oAuth2Response.getEmail();
    Gender gender = Gender.valueOf(oAuth2Response.getGender().toUpperCase());
    String phone = oAuth2Response.getPhone();

    // null 체크 후 로그 출력
    if (userId == null) {
      logger.warn("User ID is null.");
    } else {
      logger.info("User ID: {}", userId);
    }

    if (userName == null) {
      logger.warn("User Name is null.");
    } else {
      logger.info("User Name: {}", userName);
    }

    if (userEmail == null) {
      logger.warn("User Email is null.");
    } else {
      logger.info("User Email: {}", userEmail);
    }

    if (gender == null) {
      logger.warn("User gender is null");
    } else {
      logger.info("User gender: {}", gender);
    }

    if (phone == null) {
      logger.warn("User phone number is null");
    } else {
      logger.info("User phone number: {}", phone);
    }



    // 넘어온 회원정보가 이미 우리의 테이블에 존재하는지 확인
    WbUser existWbUser = wbUserRepository.findByUserId(userId);

    // 존재하지 않는다면 회원정보를 저장하고 CustomOAuth2User 반환
    if(existWbUser == null) {

      WbUser newWbUser = new WbUser();
      newWbUser.setUserId(userId);
      newWbUser.setName(oAuth2Response.getName());
      newWbUser.setEmail(oAuth2Response.getEmail());
      newWbUser.setGender(Gender.valueOf(oAuth2Response.getGender().toUpperCase()));
      newWbUser.setCreatedAt(new Date());

      wbUserRepository.save(newWbUser); // 회원 정보 저장 (사실상의 최초 회원가입)

      OAuthDTO userDTO = new OAuthDTO();
      userDTO.setId(userId);
      userDTO.setName(oAuth2Response.getName());

      return new WbUserDetail(userDTO);
    } else {		// 회원정보가 존재한다면 조회된 데이터로 반환한다.
      OAuthDTO userDTO = new OAuthDTO();
      userDTO.setId(userId);
      userDTO.setName(oAuth2Response.getName());

      return new WbUserDetail(userDTO);
    }
  }

}