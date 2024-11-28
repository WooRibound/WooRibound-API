package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.individual.dto.JobPostingProjection;
import com.wooribound.api.individual.dto.UserJobPostingReqDTO;
import com.wooribound.domain.interestjob.InterestJobRepository;
import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.jobposting.JobPostingRepository;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.domain.workhistory.WorkHistoryRepository;
import com.wooribound.global.constant.YN;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class WbUserJobPostingServiceImpl implements WbUserJobPostingService {

    private final JobPostingRepository jobPostingRepository;
    private final WbUserRepository wbUserRepository;
    private final InterestJobRepository interestJobRepository;
    private final WorkHistoryRepository workHistoryRepository;

    // 1. 공고 조회 - 검색 (회사명, 직무, 지역)
    public List<JobPostingDTO> getJobPostings(UserJobPostingReqDTO userJobPostingReqDTO) {
        String entName = userJobPostingReqDTO.getEntName();
        String jobName = userJobPostingReqDTO.getJobName();
        String entAddr1 = userJobPostingReqDTO.getEntAddr1();

        log.info("검색 START : entName - " + entName + " , jobName - " + jobName + " , entAddr1 - " + entAddr1);
        List<JobPostingProjection> jobPostings = jobPostingRepository.findJobPostings(entName, jobName, entAddr1);
        return mapJobPostingsToDTOs(jobPostings);
    }

    // 2. 공고 조회 - 새로운 일 구하기
    public List<JobPostingDTO> getJobPostingsForNew(String loginId, UserJobPostingReqDTO userJobPostingReqDTO) {
        List<JobPostingProjection> jobPostingsProjections; // 조회 결과
        List<String> interestJobs; // 관심직종
        List<String> exJobs;      // 경력직종

        log.info("새로운 일 구하기 START, loginId: {}", loginId);

        // 1. Authentication이 없으면 전체 조회
        if (loginId == null) {
            log.info("Authentication is null.");
            jobPostingsProjections = jobPostingRepository.findAllJobPostingProjections();
            return mapJobPostingsToDTOs(jobPostingsProjections);
        }

        // 2. 사용자 정보 가져오기
        Optional<WbUser> optionalUser = wbUserRepository.findById(loginId);
        if (optionalUser.isEmpty()) {
            log.warn("User not found for loginId: {}. Performing full job postings retrieval.", loginId);
            jobPostingsProjections = jobPostingRepository.findAllJobPostingProjections();
            return mapJobPostingsToDTOs(jobPostingsProjections);
        }

        WbUser user = optionalUser.get();

        // 3. interestChk가 Y가 아닌 경우 전체 조회
        if (user.getInterestChk() != YN.Y) {
            log.info("InterestChk = N  ---> 전체조회 ");
            jobPostingsProjections = jobPostingRepository.findAllJobPostingProjections();
            return mapJobPostingsToDTOs(jobPostingsProjections);
        }

        // 4. 관심직종과 경력직종 가져오기
        interestJobs = interestJobRepository.findJobNamesByUserId(loginId);
        exJobs = user.getExjobChk() == YN.Y ? workHistoryRepository.findJobNamesByUserId(loginId) : List.of();

        log.info("loginId: {}, 관심직종: {}, 경력직종: {}", loginId, interestJobs, exJobs);

        // 5. 관심직종과 경력직종이 모두 없으면 전체 조회
        if (interestJobs.isEmpty() && exJobs.isEmpty()) {
            log.info("No interest jobs or experience jobs found. Performing full job postings retrieval.");
            jobPostingsProjections = jobPostingRepository.findAllJobPostingProjections();
        } else {
            // 6. 관심직종 또는 경력직종 기준으로 조회
            log.info("Performing job postings retrieval based on interest or experience jobs.");
            jobPostingsProjections = jobPostingRepository.findJobPostingsNew(
                    exJobs.isEmpty() ? null : exJobs,
                    interestJobs.isEmpty() ? null : interestJobs);
        }

        return mapJobPostingsToDTOs(jobPostingsProjections);
    }


    // 3. 공고 조회 - 경력 살리기
    public List<JobPostingDTO> getJobPostingsForCareer(String loginId, UserJobPostingReqDTO userJobPostingReqDTO) {
       // String loginId = userJobPostingReqDTO.getloginId();
        List<JobPostingProjection> jobPostingsProjections = List.of();

        log.info("경력 살리기 START, loginId: {}", loginId);

        // 1. Authentication이 없으면 전체 조회
        if (loginId == null) {
            log.info("Authentication is null. Performing full job postings retrieval.");
            jobPostingsProjections = jobPostingRepository.findAllJobPostingProjections();
            return mapJobPostingsToDTOs(jobPostingsProjections);
        }

        // 2. 사용자 정보 가져오기
        Optional<WbUser> optionalUser = wbUserRepository.findById(loginId);
        if (optionalUser.isEmpty()) {
            log.warn("User not found for loginId: {}. Performing full job postings retrieval.", loginId);
            jobPostingsProjections = jobPostingRepository.findAllJobPostingProjections();
            return mapJobPostingsToDTOs(jobPostingsProjections);
        }

        WbUser user = optionalUser.get();

        log.info("loginId: {}, 경력직종 등록 여부: {}", loginId, user.getExjobChk());

        // 3. 경력직종이 등록되지 않은 경우 전체 조회
        List<String> exJobs = user.getExjobChk() == YN.Y
                ? workHistoryRepository.findJobNamesByUserId(loginId)
                : List.of();

        if (exJobs.isEmpty()) {
            log.info("No experience jobs found. Performing full job postings retrieval.");
            jobPostingsProjections = jobPostingRepository.findAllJobPostingProjections();
        } else {
            log.info("Performing job postings retrieval based on experience jobs: {}", exJobs);
            jobPostingsProjections = jobPostingRepository.findJobPostingsCareer(exJobs);
        }

        return mapJobPostingsToDTOs(jobPostingsProjections);
    }


    // 4. JobPosting -> DTO 변환 공통 메소드
    public List<JobPostingDTO> mapJobPostingsToDTOs(List<JobPostingProjection> jobPostings) {
        return jobPostings.stream()
                .map(job -> JobPostingDTO.builder()
                        .jobPostingId(job.getPostId())
                        .entName(job.getEntName())
                        .postImg(job.getPostImg())
                        .postTitle(job.getPostTitle())
                        .startDate(job.getStartDate())
                        .endDate(job.getEndDate())
                        .entAddr1(job.getEnterprise().getEntAddr1())
                        .entAddr2(job.getEnterprise().getEntAddr2())
                        .postState(job.getPostState())
                        .jobName(job.getJobName())
                        .build())
                .collect(Collectors.toList());
    }


    // 5. 공고 상세 조회
    @Override
    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        // log4j - 공고 상세 조회 시작 로그
        log.info("공고 상세 조회 요청 - ID: {}", postId);

        Optional<JobPosting> jobPostingOptional = jobPostingRepository.findById(postId);
        if (jobPostingOptional.isPresent()) {
            JobPosting jobPosting = jobPostingOptional.get();

            // log4j - 조회된 공고 상세 로그
            log.info("공고 상세 조회 결과 - ID: {}, Title: {}", jobPosting.getPostId(), jobPosting.getPostTitle());

            // 포스팅 카운트 수 +1 업데이트
            jobPosting.setPostingCnt(jobPostingRepository.getMaxPostingCnt().orElse(0L) + 1);
            jobPostingRepository.save(jobPosting);

            return JobPostingDetailDTO.builder()
                    .postTitle(jobPosting.getPostTitle())
                    .entName(jobPosting.getEnterprise().getEntName())
                    .postImg(jobPosting.getPostImg())
                    .startDate(jobPosting.getStartDate())
                    .endDate(jobPosting.getEndDate())
                    .jobName(jobPosting.getJob().getJobName())
                    .postingCnt(jobPosting.getPostingCnt())
                    .entAddr1(jobPosting.getEnterprise().getEntAddr1())
                    .entAddr2(jobPosting.getEnterprise().getEntAddr2())
                    .build();
        } else {
            // 공고가 존재하지 않는 경우 예외 로그
            log.error("공고가 존재하지 않습니다 - ID: {}", postId);
            // 공고가 존재하지 않는 경우 예외 처리
            throw new RuntimeException("해당 공고 없음: " + postId);
        }
    }

    public List<JobPostingDTO> getRecommendedJobPostings() {
        // Pageable -> JPA 제공 인터페이스 객체 생성 (최대 10개만 조회)
        Pageable pageable = PageRequest.of(0, 10);

        List<JobPostingProjection> jobPostings = jobPostingRepository.findByOrderByPostingCntDesc(pageable);

        if (jobPostings.isEmpty()) {
            return Collections.emptyList();
        }

        return mapJobPostingsToDTOs(jobPostings);
    }

    @Override
    public List<JobPostingDTO> getRecentJobPostings() {
        // Pageable -> JPA 제공 인터페이스 객체 생성 (최대 10개만 조회)
        Pageable pageable = PageRequest.of(0, 10);

        List<JobPostingProjection> jobPostings = jobPostingRepository.findByOrderByCreatedAtDesc(pageable);

        if (jobPostings.isEmpty()) {
            return Collections.emptyList();
        }

        return mapJobPostingsToDTOs(jobPostings);
    }


}