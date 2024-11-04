package com.wooribound.global.security;

import com.wooribound.domain.individual.dto.OAuthDTO;
import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.domain.individual.repository.WbUserRepository;
import com.wooribound.global.constant.Gender;
import com.wooribound.global.security.OauthResponseDTO.NaverResponse;
import com.wooribound.global.security.OauthResponseDTO.OAuth2Response;
import com.wooribound.global.security.WbUserDetail;
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

  @Override
  public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
    // 부모 클래스의 메서드를 사용하여 객체를 생성함.
    OAuth2User oAuth2User = super.loadUser(request);

    OAuth2Response oAuth2Response = null;

    // oAuth2User 객체로 부터 응답값을 꺼냄.
    oAuth2Response = new NaverResponse(oAuth2User.getAttributes());

    // 응답 객체에서 Id값을 꺼냄 이를 userId로 활용하고, redis에서도 key로 쓰일 예정
    String userId = oAuth2Response.getId();

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