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

            List<Long> workHistoryIds = user.getWorkHistories().stream()
                    .map(workHistory -> workHistory.getJob().getJobId())
                    .collect(Collectors.toList());

            List<Long> interestJobIds = user.getInterestJobs().stream()
                    .map(interestJob -> interestJob.getJob().getJobId())
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
                    .workHistoryJobs(workHistoryIds)
                    .interestJobs(interestJobIds)
                    .build();

        } catch (NoWbUserException e) {
            log.error("사용자 조회 실패: userId - {}", userId);
            throw e;
        }
    }

    // 2. 사용자 정보 수정
    @Override
    public WbUserUpdateDTO updateUserInfo(WbUserUpdateDTO wbUserUpdateDTO) {

        Optional<WbUser> byUserId = wbUserRepository.findByUserId(wbUserUpdateDTO.getUserId());

        if (byUserId.isEmpty()) {
            throw new NoWbUserException("사용자를 찾을 수 없습니다. ID: " + wbUserUpdateDTO.getUserId());
        }

        WbUser wbUser = byUserId.get();

        // 경력 직종 업데이트
        if (wbUserUpdateDTO.getExjobChk() != null) {
            wbUser.setExjobChk(wbUserUpdateDTO.getExjobChk());
            updateWorkHistories(wbUserUpdateDTO, wbUserUpdateDTO.getWorkHistoryJobs());
        }

        // 관심 직종 업데이트
        if (wbUserUpdateDTO.getInterestJobs() != null) {
            updateInterestJobs(wbUserUpdateDTO, wbUserUpdateDTO.getInterestJobs());
        }

        // 사용자 정보 업데이트
        if (wbUserUpdateDTO.getName() != null) {
            wbUser.setName(wbUserUpdateDTO.getName());
        }
        if (wbUserUpdateDTO.getPhone() != null) {
            wbUser.setPhone(wbUserUpdateDTO.getPhone());
        }
        if (wbUserUpdateDTO.getGender() != null) {
            wbUser.setGender(wbUserUpdateDTO.getGender());
        }
        if (wbUserUpdateDTO.getAddrCity() != null) {
            wbUser.setAddrCity(wbUserUpdateDTO.getAddrCity());
        }
        if (wbUserUpdateDTO.getAddrProvince() != null) {
            wbUser.setAddrProvince(wbUserUpdateDTO.getAddrProvince());
        }
        if (wbUserUpdateDTO.getDataSharingConsent() != null) {
            wbUser.setDataSharingConsent(wbUserUpdateDTO.getDataSharingConsent());
        }
        if (wbUserUpdateDTO.getExjobChk() != null) {
        }

        // 최종 저장
        WbUser savedUser = wbUserRepository.save(wbUser);

        List<Long> workHistoryIds = savedUser.getWorkHistories().stream()
                .map(workHistory -> workHistory.getJob().getJobId())
                .collect(Collectors.toList());

        List<Long> interestJobIds = savedUser.getInterestJobs().stream()
                .map(interestJob -> interestJob.getJob().getJobId())
                .collect(Collectors.toList());

        return WbUserUpdateDTO.builder()
                .userId(savedUser.getUserId())
                .name(savedUser.getName())
                .birth(savedUser.getBirth())
                .phone(savedUser.getPhone())
                .gender(savedUser.getGender())
                .exjobChk(savedUser.getExjobChk())
                .addrCity(savedUser.getAddrCity())
                .addrProvince(savedUser.getAddrProvince())
                .jobInterest(savedUser.getJobInterest())
                .dataSharingConsent(savedUser.getDataSharingConsent())
                .workHistoryJobs(workHistoryIds)
                .interestJobs(interestJobIds)
                .build();
    }

    private void updateInterestJobs(WbUserUpdateDTO user, List<Long> interestJobs) {
        // 기존 관심 직종 삭제
        interestJobRepository.deleteByUserId(user.getUserId());

        // 새로운 관심 직종 추가
        if (interestJobs != null && !interestJobs.isEmpty()) {
            List<InterestJob> newInterestJobs = interestJobs.stream()
                    .map(jobId -> {
                        Optional<Job> job = jobRepository.findById(jobId);
                        if (job.isEmpty()) {
                            log.warn("존재하지 않는 관심 직종: {}", jobId);
                            return null;
                        }
                        return InterestJob.builder()
                                .job(job.get())
                                .wbUser(wbUserRepository.findByUserId(user.getUserId()).orElseThrow())
                                .build();
                    })
                    .filter(interestJob -> interestJob != null)
                    .collect(Collectors.toList());
            interestJobRepository.saveAll(newInterestJobs);
        }
    }

    private void updateWorkHistories(WbUserUpdateDTO user, List<Long> workHistoryJobs) {
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
                    .map(jobId -> {
                        Optional<Job> job = jobRepository.findById(jobId);
                        if (job.isEmpty()) {
                            log.warn("존재하지 않는 경력 직종: {}", jobId);
                            return null;
                        }
                        return WorkHistory.builder()
                                .job(job.get())
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
                .exjobChk(user.getExjobChk()) // 경력 여부
                .interestChk(user.getInterestChk()) // 관심 직종 여부
                .addrCity(user.getAddrCity())
                .addrProvince(user.getAddrProvince())
                .jobPoint(user.getJobPoint())
                .jobInterest(user.getJobInterest()) //
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
