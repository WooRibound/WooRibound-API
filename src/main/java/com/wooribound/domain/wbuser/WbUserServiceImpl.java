package com.wooribound.domain.wbuser;

import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserJoinDTO;
import com.wooribound.api.individual.dto.WbUserUpdateDTO;
import com.wooribound.domain.workhistory.WorkHistory;
import com.wooribound.domain.workhistory.WorkHistoryRepository;
import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;
import com.wooribound.global.exception.JoinWbUserException;
import com.wooribound.global.exception.NoWbUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WbUserServiceImpl implements WbUserService {

    private static final Logger logger = LoggerFactory.getLogger(WbUserServiceImpl.class);

    private final WbUserRepository wbUserRepository;
    private final WorkHistoryRepository workHistoryRepository;

    @Autowired
    public WbUserServiceImpl(WbUserRepository wbUserRepository, WorkHistoryRepository workHistoryRepository) {
        this.wbUserRepository = wbUserRepository;
        this.workHistoryRepository = workHistoryRepository;
    }

    // 1. 사용자 정보 조회
    @Override
    public WbUserDTO getUserInfo(String userId) {
        try {
            WbUser user = wbUserRepository.findByUserId(userId).orElseThrow(NoWbUserException::new);
            List<WorkHistory> workHistoryList = workHistoryRepository.findByUserId(userId);

            List<String> workHistoryNames = user.getWorkHistories().stream()
                    .map(workHistory -> workHistory.getJob().getJobName())
                    .collect(Collectors.toList());

            // 관심 직종 이름 리스트 생성
            List<String> interestJobNames = user.getInterestJobs().stream()
                    .map(interestJob -> interestJob.getJob().getJobName())
                    .collect(Collectors.toList());

            return WbUserDTO.builder()
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
                    .workHistoryJobs(workHistoryNames)
                    .interestJobs(interestJobNames)
                    .build();

        } catch (Exception e) {
            logger.error("사용자 정보 조회 중 오류 발생: {}", e.getMessage());
            return null;
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
            user.setGender(wbUserUpdateDTO.getGender());
            user.setExjobChk(wbUserUpdateDTO.getExjobChk());
            user.setJobInterest(wbUserUpdateDTO.getJobInterest());
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

    @Override
    public void saveWbUser(WbUser wbUser) {
        wbUserRepository.save(wbUser);
    }

    @Override
    public String craeteWbUser(WbUserJoinDTO wbUserJoinDTO) {
        try {
            WbUser user = wbUserRepository.findByUserId(wbUserJoinDTO.getUserId())
                .orElseThrow(NoWbUserException::new);

            // WbUserUpdateDTO의 필드만 업데이트
            user.setName(wbUserJoinDTO.getName());
            user.setBirth(wbUserJoinDTO.getBirth());
            user.setPhone(wbUserJoinDTO.getPhone());
            user.setGender(wbUserJoinDTO.getGender());
            user.setExjobChk(wbUserJoinDTO.getExjobChk());
            user.setJobInterest(wbUserJoinDTO.getJobInterest());
            user.setAddrCity(wbUserJoinDTO.getAddrCity());
            user.setAddrProvince(wbUserJoinDTO.getAddrProvince());
            user.setUpdatedAt(new Date());
            user.setDataSharingConsent(wbUserJoinDTO.getDataSharingConsent());
            user.setInterestChk(wbUserJoinDTO.getInterestChk());
            wbUserRepository.save(user);
            return "사용자 정보가 성공적으로 수정되었습니다.";
        }catch (NoWbUserException e){
            throw e;
        } catch (Exception e) {
            throw new JoinWbUserException();
        }
    }

    @Override
    public WbUserDTO getOneUserInfo(String userId) {
        WbUser user = wbUserRepository.findByUserId(userId).orElseThrow();

        return WbUserDTO.builder()
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
            .build();
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

    @Override
    public WbUser getWbUser(String userId) {
        return wbUserRepository.findByUserId(userId).orElseThrow(NoWbUserException::new);
    }

    @Override
    public void addWbscore(String userId, int addScore) {
        WbUser wbUser = wbUserRepository.findByUserId(userId).orElseThrow(NoWbUserException::new);
        int score = wbUser.getJobPoint() + addScore;
        wbUser.setJobPoint(score);
        wbUserRepository.save(wbUser);
    }
}
