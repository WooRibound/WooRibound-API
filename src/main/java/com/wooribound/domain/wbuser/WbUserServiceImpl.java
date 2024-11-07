package com.wooribound.domain.wbuser;

import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserUpdateDTO;
import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WbUserServiceImpl implements WbUserService {

    private static final Logger logger = LoggerFactory.getLogger(WbUserServiceImpl.class);

    private final WbUserRepository wbUserRepository;

    @Autowired
    public WbUserServiceImpl(WbUserRepository wbUserRepository) {
        this.wbUserRepository = wbUserRepository;
    }

    // 1. 사용자 정보 조회
    @Override
    public List<WbUserDTO> getUserInfo(String userId) {
        try {
            Optional<WbUser> optionalUser = wbUserRepository.findByUserId(userId);
            if (optionalUser.isEmpty()) {
                logger.warn("사용자 ID가 존재하지 않습니다: {}", userId);
                return Collections.emptyList();
            }

            WbUser user = optionalUser.get();
            return Collections.singletonList(
                    WbUserDTO.builder()
                            .userId(user.getUserId())
                            .name(user.getName())
                            .birth(user.getBirth())
                            .email(user.getEmail())
                            .phone(user.getPhone())
                            .gender(user.getGender())
                            .exjobChk(user.getExjobChk())
                            .interestChk(user.getInterestChk())
                            .addrCity(user.getAddrCity())
                            .addrProvince(user.getAddrProvince())
                            .jobPoint(user.getJobPoint())
                            .jobInterest(user.getJobInterest())
                            .createdAt(user.getCreatedAt())
                            .updatedAt(user.getUpdatedAt())
                            .isDeleted(user.getIsDeleted())
                            .build()
            );
        } catch (Exception e) {
            logger.error("사용자 정보 조회 중 오류 발생: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    // 2. 사용자 정보 수정
    @Override
    public String updateUserInfo(WbUserUpdateDTO wbUserUpdateDTO) {
        try {
            Optional<WbUser> optionalUser = wbUserRepository.findByUserId(wbUserUpdateDTO.getUserId());
            if (optionalUser.isEmpty()) {
                return "사용자 정보를 찾을 수 없습니다.";
            }

            WbUser user = optionalUser.get();

            // WbUserUpdateDTO의 필드만 업데이트
            user.setName(wbUserUpdateDTO.getName());
            user.setBirth(wbUserUpdateDTO.getBirth());
            user.setPhone(wbUserUpdateDTO.getPhone());
            user.setGender(Gender.valueOf(wbUserUpdateDTO.getGender()));
            user.setExjobChk(YN.valueOf(wbUserUpdateDTO.getExjobChk()));
            user.setJobInterest(YN.valueOf(wbUserUpdateDTO.getJobInterest()));
            user.setAddrCity(wbUserUpdateDTO.getAddrCity());
            user.setAddrProvince(wbUserUpdateDTO.getAddrProvince());

            user.setUpdatedAt(new Date());

            wbUserRepository.save(user);
            return "사용자 정보가 성공적으로 수정되었습니다.";
        } catch (Exception e) {
            logger.error("사용자 정보 수정 중 오류 발생: {}", e.getMessage());
            return "사용자 정보 수정 중 오류가 발생했습니다.";
        }
    }
    // 3. 우바 점수 조회
    @Override
    public int getJobPoint(String userId) {
        Optional<WbUser> optionalUser = wbUserRepository.findByUserId(userId);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("사용자 정보를 찾을 수 없습니다.");
        }

        return optionalUser.get().getJobPoint();  // job_point 반환
    }
}
