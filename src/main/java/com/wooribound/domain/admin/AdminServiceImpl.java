package com.wooribound.domain.admin;

import com.wooribound.api.admin.dto.AdminApproveReqDTO;
import com.wooribound.domain.admin.dto.AdminDTO;
import com.wooribound.domain.enterprise.EnterpriseRepository;
import com.wooribound.global.constant.YN;
import com.wooribound.global.exception.NoApproveStatusException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final EnterpriseRepository enterpriseRepository;


    @Override
    public void create(AdminDTO adminDTO) {
        String encodedPW = passwordEncoder.encode(adminDTO.getAdminPw());
        adminDTO.setAdminPw(encodedPW);
        adminRepository.save(Admin.fromDTO(adminDTO));
    }

    @Override
    public String joinApprove(AdminApproveReqDTO adminApproveReqDTO) {
        if (adminApproveReqDTO.getApprove() == null)
            throw new NoApproveStatusException();

        // 기업 회원가입을 반려할 때
        if (adminApproveReqDTO.getApprove() == YN.N) {
            if (enterpriseRepository.deleteByEntId(adminApproveReqDTO.getEntId()) == 1)
                return "[" + adminApproveReqDTO.getEntId() + "] 기업의 회원가입이 반려되었습니다.";
            else
                return "[" + adminApproveReqDTO.getEntId() + "] 기업의 회원가입 반려가 정상적으로 수행되지 않았습니다.";
        }
        // 기업 회원가입을 승인할 때
        else {
            if (enterpriseRepository.updateUpdatedAt(adminApproveReqDTO.getEntId()) == 1)
                return "[" + adminApproveReqDTO.getEntId() + "] 기업의 회원가입이 승인되었습니다.";
            else
                return "[" + adminApproveReqDTO.getEntId() + "] 기업의 회원가입 승인이 정상적으로 수행되지 않았습니다.";
        }
    }

    @Override
    public String deleteApprove(AdminApproveReqDTO adminApproveReqDTO) {
        if (adminApproveReqDTO.getApprove() == null)
            throw new NoApproveStatusException();

        // 기업 회원탈퇴를 승인할 때
        if (adminApproveReqDTO.getApprove() == YN.Y) {
            if (enterpriseRepository.updateIsDeleted(adminApproveReqDTO.getEntId()) == 1)
                return "[" + adminApproveReqDTO.getEntId() + "] 기업의 회원탈퇴가 승인되었습니다.";
            else
                return "[" + adminApproveReqDTO.getEntId() + "] 기업의 회원탈퇴 승인이 정상적으로 수행되지 않았습니다.";
        }
        // 기업 회원탈퇴를 반려할 때
        else {
            if (enterpriseRepository.updateDeleteRequestedAt(adminApproveReqDTO.getEntId()) == 1)
                return "[" + adminApproveReqDTO.getEntId() + "] 기업의 회원탈퇴가 반려되었습니다.";
            else
                return "[" + adminApproveReqDTO.getEntId() + "] 기업의 회원탈퇴 반려가 정상적으로 수행되지 않았습니다.";
        }
    }
}
