package com.wooribound.global.security.userdetail.wbuser;

import com.wooribound.api.individual.dto.OAuthDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;
import com.wooribound.global.exception.DeletedUserException;
import com.wooribound.global.security.dto.NaverResponse;
import com.wooribound.global.security.dto.OAuth2Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Slf4j
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

    if (oAuth2Response == null) {
      log.warn("NaverResponse is null.");// 또는 예외를 던질 수 있습니다.
    }
    System.out.println("네이버로부터 정보 받아오기");
    
    // NaverResponse에서 데이터 추출
    String userId = oAuth2Response.getId();
    String userName = oAuth2Response.getName();
    String userEmail = oAuth2Response.getEmail();
    Gender gender = oAuth2Response.getGender();
    String phone = oAuth2Response.getPhone();
    Date birth = oAuth2Response.getBirth();



    // 넘어온 회원정보가 이미 우리의 테이블에 존재하는지 확인
    Optional<WbUser> existWbUser = wbUserRepository.findById(userId);

    // 존재하지 않는다면 회원정보를 저장하고 CustomOAuth2User 반환
    if(existWbUser.isEmpty()) {

      WbUser newWbUser = new WbUser();

  // userId에 대한 null 체크
      if (userId == null) {
        log.warn("User ID is null.");
        throw new IllegalArgumentException("User ID cannot be null.");
      }
      newWbUser.setUserId(userId);

// name에 대한 null 체크
      if (userName == null) {
        log.warn("User Name is null.");
        throw new IllegalArgumentException("User Name cannot be null.");
      }
      newWbUser.setName(userName);

// email에 대한 null 체크
      if (userEmail == null) {
        log.warn("User Email is null.");
      } else{
        newWbUser.setEmail(userEmail);
      }


// gender에 대한 null 체크 및 변환

      newWbUser.setGender(gender);
      newWbUser.setPhone(phone);
      newWbUser.setBirth(birth);

// createdAt 필드에 현재 날짜 설정
      newWbUser.setCreatedAt(new Date());
      System.out.println("새 유저 저장");
      wbUserRepository.save(newWbUser); // 회원 정보 저장 (사실상의 최초 회원가입)
    
      OAuthDTO userDTO = new OAuthDTO();
      userDTO.setId(userId);
      userDTO.setFirstLogin(YN.Y);
      userDTO.setName(userName);

      return new WbUserDetail(userDTO);
    } else {		// 회원정보가 존재한다면 조회된 데이터로 반환한다.

      if(existWbUser.get().getIsDeleted() == YN.Y){
        // OAuth2Error와 함께 OAuth2AuthenticationException을 throw
        throw new OAuth2AuthenticationException(
            new OAuth2Error("deleted_user", "탈퇴한 유저입니다. 회원가입을 새로 진행해 주세요", null),
            new DeletedUserException("탈퇴한 유저입니다. 회원가입을 새로 진행해 주세요")
        );
      }
      System.out.println("기존 유저 반환");
      OAuthDTO userDTO = new OAuthDTO();
      userDTO.setId(userId);
      userDTO.setFirstLogin(YN.N);
      userDTO.setName(oAuth2Response.getName());

      return new WbUserDetail(userDTO);
    }
  }

}