package com.wooribound.global.util;

import com.wooribound.domain.enterprise.Enterprise;
import com.wooribound.global.exception.AuthenticationException;
import com.wooribound.global.security.userdetail.admin.AdminUserDetail;
import com.wooribound.global.security.userdetail.enterprise.EnterpriseUserDetail;
import com.wooribound.global.security.userdetail.wbuser.WbUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateUtil {
  public String CheckWbUserAuthAndGetUserId(Authentication authentication) {
    try {
      WbUserDetail wbUserDetail = (WbUserDetail) authentication.getPrincipal();
      return wbUserDetail.getId();
    } catch (Exception e) {
      throw new AuthenticationException();
    }
  }

  public String CheckEnterpriseAuthAndGetUserId(Authentication authentication) {
    try {
      EnterpriseUserDetail enterpriseUserDetail = (EnterpriseUserDetail) authentication.getPrincipal();
      return enterpriseUserDetail.getUserId();
    } catch (Exception e) {
      e.printStackTrace();
      throw new AuthenticationException();
    }
  }

  public String CheckAdminAuthAndGetUserId(Authentication authentication) {
    try {
      AdminUserDetail adminUserDetail = (AdminUserDetail) authentication.getPrincipal();
      return adminUserDetail.getId();
    } catch (Exception e) {
      throw new AuthenticationException();
    }
  }
}
