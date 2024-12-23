package com.wooribound.global.security.userdetail.admin;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AdminUserDetail implements UserDetails {
  private final String userId;
  private final String password;

  private final String username;
  private final Collection<? extends GrantedAuthority> authorities;

  public AdminUserDetail(String userId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.authorities = authorities;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public String getId() {
    return userId;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true; // 만료되지 않음
  }

  @Override
  public boolean isAccountNonLocked() {
    return true; // 잠기지 않음
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true; // 자격 증명이 만료되지 않음
  }

  @Override
  public boolean isEnabled() {
    return true; // 사용 가능
  }
}

