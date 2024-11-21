package com.wooribound.domain.wbuser;

import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserJoinDTO;
import com.wooribound.api.individual.dto.WbUserUpdateDTO;
import com.wooribound.domain.interestjob.InterestJob;
import com.wooribound.domain.interestjob.InterestJobRepository;
import com.wooribound.domain.job.Job;
import com.wooribound.domain.job.JobRepository;
import com.wooribound.domain.workhistory.WorkHistory;
import com.wooribound.domain.workhistory.WorkHistoryRepository;
import com.wooribound.global.constant.YN;
import com.wooribound.global.exception.JoinWbUserException;
import com.wooribound.global.exception.NoWbUserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class WbUserServiceImpl implements WbUserService {

    private final WbUserRepository wbUserRepository;
    private final WorkHistoryRepository workHistoryRepository;
    private final InterestJobRepository interestJobRepository;
    private final JobRepository jobRepository;

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
                    .dataSharingConsent(user.getDataSharingConsent())
                    .jobInterest(user.getJobInterest())
                    .isDeleted(user.getIsDeleted())
                    .workHistoryJobs(workHistoryNames)
                    .interestJobs(interestJobNames)
                    .build();

        } catch (NoWbUserException e) {
            log.error("사용자 조회 실패: userId - {}", userId);
            throw e;
        }
    }

    // 2. 사용자 정보 수정
    @Override
    public WbUserUpdateDTO updateUserInfo(WbUserUpdateDTO wbUserUpdateDTO) {

        WbUserDTO user = wbUserRepository.findByUserId(wbUserUpdateDTO.getUserId())
                .map(wbUser -> WbUserDTO.builder()
                        .userId(wbUser.getUserId())
                        .name(wbUser.getName())
                        .birth(wbUser.getBirth())
                        .email(wbUser.getEmail())
                        .phone(wbUser.getPhone())
                        .gender(wbUser.getGender())
                        .exjobChk(wbUser.getExjobChk())
                        .interestChk(wbUser.getInterestChk())
                        .addrCity(wbUser.getAddrCity())
                        .addrProvince(wbUser.getAddrProvince())
                        .jobPoint(wbUser.getJobPoint())
                        .jobInterest(wbUser.getJobInterest())
                        .isDeleted(wbUser.getIsDeleted())
                        .workHistoryJobs(wbUser.getWorkHistories().stream()
                                .map(workHistory -> workHistory.getJob().getJobName()) // WorkHistory -> Job -> JobName
                                .toList())
                        .interestJobs(wbUser.getInterestJobs().stream()
                                .map(interestJob -> interestJob.getJob().getJobName()) // InterestJob -> Job -> JobName
                                .toList())
                        .build())
                .orElseThrow(() -> new NoWbUserException("사용자를 찾을 수 없습니다. ID: " + wbUserUpdateDTO.getUserId()));

        user.setExjobChk(wbUserUpdateDTO.getExjobChk());

        // 관심 직종 업데이트
        if (wbUserUpdateDTO.getInterestJobs() != null) {
            updateInterestJobs(user, wbUserUpdateDTO.getInterestJobs());
        }

        if (wbUserUpdateDTO.getExjobChk() != null) {
            user.setExjobChk(wbUserUpdateDTO.getExjobChk());
            // 경력 직종 업데이트
            updateWorkHistories(user, wbUserUpdateDTO.getWorkHistoryJobs());
        }

        // 최신 데이터 조회
        WbUser updatedUser = wbUserRepository.findByUserId(user.getUserId())
                .orElseThrow(() -> new NoWbUserException("업데이트 후 사용자 조회 실패: ID: " + user.getUserId()));

        // 사용자 정보 업데이트
        if (wbUserUpdateDTO.getName() != null) {
            updatedUser.setName(wbUserUpdateDTO.getName());
        }
        if (wbUserUpdateDTO.getPhone() != null) {
            updatedUser.setPhone(wbUserUpdateDTO.getPhone());
        }
        if (wbUserUpdateDTO.getGender() != null) {
            updatedUser.setGender(wbUserUpdateDTO.getGender());
        }
        if (wbUserUpdateDTO.getAddrCity() != null) {
            updatedUser.setAddrCity(wbUserUpdateDTO.getAddrCity());
        }
        if (wbUserUpdateDTO.getAddrProvince() != null) {
            updatedUser.setAddrProvince(wbUserUpdateDTO.getAddrProvince());
        }
        if (wbUserUpdateDTO.getExjobChk() != null) {
        }

        // 최종 저장
        wbUserRepository.save(updatedUser);

        return WbUserUpdateDTO.builder()
                .userId(updatedUser.getUserId())
                .name(updatedUser.getName())
                .birth(updatedUser.getBirth())
                .phone(updatedUser.getPhone())
                .gender(updatedUser.getGender())
                .exjobChk(updatedUser.getExjobChk())
                .addrCity(updatedUser.getAddrCity())
                .addrProvince(updatedUser.getAddrProvince())
                .jobInterest(updatedUser.getJobInterest())
                .workHistoryJobs(updatedUser.getWorkHistories().stream()
                        .map(workHistory -> workHistory.getJob().getJobName())
                        .collect(Collectors.toList()))
                .interestJobs(updatedUser.getInterestJobs().stream()
                        .map(interestJob -> interestJob.getJob().getJobName())
                        .collect(Collectors.toList()))
                .build();
    }

    private void updateInterestJobs(WbUserDTO user, List<String> interestJobs) {
        // 기존 관심 직종 삭제
        interestJobRepository.deleteByUserId(user.getUserId());

        // 새로운 관심 직종 추가
        if (interestJobs != null && !interestJobs.isEmpty()) {
            List<InterestJob> newInterestJobs = interestJobs.stream()
                    .map(jobName -> {
                        Job job = jobRepository.findByJobName(jobName);
                        if (job == null) {
                            log.warn("존재하지 않는 관심 직종: {}", jobName);
                            return null;
                        }
                        return InterestJob.builder()
                                .job(job)
                                .wbUser(wbUserRepository.findByUserId(user.getUserId()).orElseThrow())
                                .build();
                    })
                    .filter(interestJob -> interestJob != null)
                    .collect(Collectors.toList());
            interestJobRepository.saveAll(newInterestJobs);
        }
    }

    private void updateWorkHistories(WbUserDTO user, List<String> workHistoryJobs) {
        // 경력 여부 확인
        log.info("ExjobChk 상태: {}", user.getExjobChk());
        if (user.getExjobChk() == YN.N) {
            // 경력이 없음으로 설정된 경우 WorkHistory 테이블에서 모든 관련 데이터 삭제
            workHistoryRepository.deleteByUserId(user.getUserId()); // 명시적으로 삭제
            return; // 더 이상 작업 없음
        }

        // 기존 경력 직종 삭제
        workHistoryRepository.deleteByUserId(user.getUserId());

        // 새로운 경력 직종 추가
        if (workHistoryJobs != null && !workHistoryJobs.isEmpty()) {
            List<WorkHistory> newWorkHistories = workHistoryJobs.stream()
                    .map(jobName -> {
                        Job job = jobRepository.findByJobName(jobName);
                        if (job == null) {
                            log.warn("존재하지 않는 경력 직종: {}", jobName);
                            return null;
                        }
                        return WorkHistory.builder()
                                .job(job)
                                .wbUser(wbUserRepository.findByUserId(user.getUserId()).orElseThrow())
                                .build();
                    })
                    .filter(workHistory -> workHistory != null)
                    .collect(Collectors.toList());
            workHistoryRepository.saveAll(newWorkHistories);
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
            user.setDataSharingConsent(wbUserJoinDTO.getDataSharingConsent());
            user.setInterestChk(wbUserJoinDTO.getInterestChk());
            wbUserRepository.save(user);
            return "사용자 정보가 성공적으로 수정되었습니다.";
        } catch (NoWbUserException e) {
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
