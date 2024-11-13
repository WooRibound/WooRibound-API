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
import com.wooribound.global.exception.NoWbUserException;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WbUserJobPostingServiceImpl implements WbUserJobPostingService {

    private static final Logger logger = LogManager.getLogger(WbUserJobPostingServiceImpl.class);
    private final JobPostingRepository jobPostingRepository;
    private final WbUserRepository wbUserRepository;
    private final InterestJobRepository interestJobRepository;
    private final WorkHistoryRepository workHistoryRepository;

    // 1. 공고 조회 - 검색 (회사명, 직무, 지역)
    public List<JobPostingDTO> getJobPostings(String loginId, UserJobPostingReqDTO userJobPostingReqDTO) {
        String entName = userJobPostingReqDTO.getEntName();
        String jobName = userJobPostingReqDTO.getJobName();
        String entAddr1 = userJobPostingReqDTO.getEntAddr1();

        logger.info("검색 START : entName - " + entName + " , jobName - " + jobName + " , entAddr1 - " + entAddr1);
        List<JobPostingProjection> jobPostings = jobPostingRepository.findJobPostings(entName, jobName, entAddr1);
        return mapJobPostingsToDTOs(jobPostings);
    }

    // 2. 공고 조회 - 새로운 일 구하기
    public List<JobPostingDTO> getJobPostingsForNew(String loginId, UserJobPostingReqDTO userJobPostingReqDTO) {
//        String loginId = userJobPostingReqDTO.getloginId();
        List<JobPostingProjection> jobPostingsProjections;
        List<String> interestJobs;
        List<String> exJobs;

        logger.info("새로운 일 구하기 START");
        if (loginId == null) {
            jobPostingsProjections = jobPostingRepository.findAllJobPostingProjections();
        } else {
            WbUser user = wbUserRepository.findById(loginId)
                    .orElseThrow(() -> new NoWbUserException());

            logger.info(loginId + ", 관심직종 등록 여부 : " + user.getInterestChk() + " 경력직종 등록 여부 : " + user.getExjobChk());
            interestJobs = user.getInterestChk() == YN.Y ? interestJobRepository.findJobNamesByUserId(loginId) : List.of();
            exJobs = user.getExjobChk() == YN.Y ? workHistoryRepository.findJobNamesByUserId(loginId) : List.of();
            logger.info(loginId + " 관심직종 목록 : " + interestJobs + ", 경력직종 목록 : " + exJobs);

            if (interestJobs.isEmpty() && exJobs.isEmpty()) {
                jobPostingsProjections = jobPostingRepository.findAllJobPostingProjections();
            } else {
                logger.info("findJobPostingsNew START :" + loginId + " 관심직종 목록 : " + interestJobs + ", 경력직종 목록 : " + exJobs);
                jobPostingsProjections = jobPostingRepository.findJobPostingsNew(exJobs.isEmpty() ? null : exJobs,
                        interestJobs.isEmpty() ? null : interestJobs);
                logger.info(loginId + " 새로운 일 공고 : " + jobPostingsProjections);
            }
        }
        return mapJobPostingsToDTOs(jobPostingsProjections);
    }


    // 3. 공고 조회 - 경력 살리기
    public List<JobPostingDTO> getJobPostingsForCareer(String loginId, UserJobPostingReqDTO userJobPostingReqDTO) {
       // String loginId = userJobPostingReqDTO.getloginId();
        List<JobPostingProjection> jobPostingsProjections = List.of();

        logger.info("경력 살리기 START");
        if (loginId == null) {
            jobPostingsProjections = jobPostingRepository.findAllJobPostingProjections();
        } else {
            WbUser user = wbUserRepository.findById(loginId)
                    .orElseThrow(() -> new NoWbUserException());

            logger.info(loginId + " 경력직종 등록 여부 : " + user.getExjobChk());
            List<String> exJobs = user.getExjobChk() == YN.Y ? workHistoryRepository.findJobNamesByUserId(loginId) : List.of();
            logger.info(loginId + " 경력직종 목록 : " + exJobs);

            if (exJobs.isEmpty()) {
                jobPostingsProjections = jobPostingRepository.findAllJobPostingProjections();
            } else {
                jobPostingsProjections = jobPostingRepository.findJobPostingsCareer(exJobs);
                logger.info(loginId + " 경력공고 : " + jobPostingsProjections);
            }
        }
        return mapJobPostingsToDTOs(jobPostingsProjections);
    }

    // 4. JobPosting -> DTO 변환 공통 메소드
    public List<JobPostingDTO> mapJobPostingsToDTOs(List<JobPostingProjection> jobPostings) {
        return jobPostings.stream()
                .map(job -> JobPostingDTO.builder()
                        .jobPostingId(job.getPostId())
                        .entName(job.getEntName())
                        .postTitle(job.getPostTitle())
                        .startDate(job.getStartDate())
                        .endDate(job.getEndDate())
                        .entAddr1(job.getEnterprise().getEntAddr1())
                        .entAddr2(job.getEnterprise().getEntAddr2())
                        .postState(job.getPostState())
                        .build())
                .collect(Collectors.toList());
    }


    // 5. 공고 상세 조회
    @Override
    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        // log4j - 공고 상세 조회 시작 로그
        logger.info("공고 상세 조회 요청 - ID: {}", postId);

        Optional<JobPosting> jobPostingOptional = jobPostingRepository.findById(postId);
        if (jobPostingOptional.isPresent()) {
            JobPosting jobPosting = jobPostingOptional.get();

            // log4j - 조회된 공고 상세 로그
            logger.info("공고 상세 조회 결과 - ID: {}, Title: {}", jobPosting.getPostId(), jobPosting.getPostTitle());
            return JobPostingDetailDTO.builder()
                    .postTitle(jobPosting.getPostTitle())
                    .entName(jobPosting.getEnterprise().getEntName())
                    .postImg(jobPosting.getPostImg())
                    .startDate(jobPosting.getStartDate())
                    .endDate(jobPosting.getEndDate())
                    .jobName(jobPosting.getJob().getJobName())
                    .entAddr1(jobPosting.getEnterprise().getEntAddr1())
                    .entAddr2(jobPosting.getEnterprise().getEntAddr2())
                    .build();
        } else {
            // 공고가 존재하지 않는 경우 예외 로그
            logger.error("공고가 존재하지 않습니다 - ID: {}", postId);
            // 공고가 존재하지 않는 경우 예외 처리
            throw new RuntimeException("해당 공고 없음: " + postId);
        }
    }


}