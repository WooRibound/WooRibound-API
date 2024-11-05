package com.wooribound.global.security.userdetail.wbuser;

import com.wooribound.api.individual.dto.OAuthDTO;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import org.springframework.security.oauth2.core.user.OAuth2User;

@RequiredArgsConstructor
public class WbUserDetail implements OAuth2User {
  private final OAuthDTO oAuthDTO;

  @Override
  public Map<String, Object> getAttributes() {
    return null;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singleton(new SimpleGrantedAuthority("ROLE_WbUser"));
  }

  public String getId() {
    return oAuthDTO.getId();
  }

  @Override
  public String getName() {
    return oAuthDTO.getName();
  }
}