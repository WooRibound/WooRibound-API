package com.wooribound.global.security.userdetail.enterprise;

import com.wooribound.domain.enterprise.Enterprise;
import com.wooribound.domain.enterprise.EnterpriseRepository;
import com.wooribound.global.constant.YN;
import com.wooribound.global.constant.YNP;
import com.wooribound.global.exception.DeletedUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EnterpriseUserDetailService implements UserDetailsService {

  @Autowired
  private final EnterpriseRepository enterpriseUserRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    Enterprise enterpriseUser = enterpriseUserRepository.findById(userId)
        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + userId));

    if (enterpriseUser.getIsDeleted() == YNP.Y) {
      throw new AuthenticationServiceException("탈퇴한 기업 회원입니다.",
          new DeletedUserException("탈퇴한 기업 회원입니다. 회원가입을 새로 진행해 주세요"));
    }

    if (enterpriseUser.getIsDeleted() == YNP.P) {
      return new EnterpriseUserDetail(
          enterpriseUser.getEntId(),
          enterpriseUser.getEntName(),
          enterpriseUser.getEntPwd(),
          List.of(() -> "ROLE_ENTERPRISE_PENDING")
      );
    }

    if (enterpriseUser.getIsDeleted() == YNP.N && enterpriseUser.getUpdatedAt() == null) {
      return new EnterpriseUserDetail(
              enterpriseUser.getEntId(),
              enterpriseUser.getEntName(),
              enterpriseUser.getEntPwd(),
              List.of(() -> "ROLE_ENTERPRISE_PENDING")
      );
    }

    return new EnterpriseUserDetail(
        enterpriseUser.getEntId(),
        enterpriseUser.getEntName(),
        enterpriseUser.getEntPwd(),
        List.of(() -> "ROLE_ENTERPRISE_USER")
    );
  }
}

