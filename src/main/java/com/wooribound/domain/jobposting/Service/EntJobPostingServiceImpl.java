package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.corporate.dto.ApplicantsDTO;
import com.wooribound.api.corporate.dto.JobPostingReqDTO;
import com.wooribound.domain.enterprise.Enterprise;
import com.wooribound.domain.enterprise.EnterpriseRepository;
import com.wooribound.domain.job.Job;
import com.wooribound.domain.job.JobRepository;
import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.jobposting.JobPostingRepository;
import com.wooribound.domain.jobposting.DTO.JobPostingDetailDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDetailProjection;
import com.wooribound.domain.userapply.UserApply;
import com.wooribound.domain.userapply.UserApplyRepository;
import com.wooribound.domain.userapply.dto.ApplicantResultReqDTO;
import com.wooribound.global.constant.ApplyResult;
import com.wooribound.global.constant.PostState;
import com.wooribound.global.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EntJobPostingServiceImpl implements EntJobPostingService {

    private static final Logger logger = LogManager.getLogger(EntJobPostingServiceImpl.class);
    private final JobPostingRepository jobPostingRepository;
    private final JobRepository jobRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final UserApplyRepository userApplyRepository;
    private final RedisUtil redisUtil;

    // 1. 공고 등록
    @Override
    public String createJobPosting(JobPostingReqDTO jobPostingReqDTO) {

        Enterprise enterprise = enterpriseRepository.findById(jobPostingReqDTO.getEntId()).orElse(null);
        Job job = jobRepository.findByJobName(jobPostingReqDTO.getJobName());

        JobPosting jobPosting = JobPosting.builder()
                .enterprise(enterprise)
                .job(job)
                .postTitle(jobPostingReqDTO.getPostTitle())
                .postImg(jobPostingReqDTO.getPostImg())
                .startDate(jobPostingReqDTO.getStartDate())
                .endDate(jobPostingReqDTO.getEndDate())
                .postState(PostState.PENDING)
                .build();
        
        jobPostingRepository.save(jobPosting);
        return "공고 등록이 완료되었습니다.";
    }

    // 2. 공고 상세
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
                                .postState(jobPosting.getPostState())
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

    // 3. 내 기업 공고 목록 조회
    @Override
    public List<JobPostingDetailProjection> getJobPostingList(String entId) {
        return jobPostingRepository.getMyJobPostings(entId);
    }

    // 4. 공고 지원자 전체 조회
    @Override
    public List<ApplicantsDTO> getJobApplicants(int postId) {
        List<UserApply> applicants = userApplyRepository.findByJobPosting_PostId(postId);

        return applicants.stream().map(applicant -> {
            // 개별 지원자의 생년월일 가져오기
            Date birthDate = applicant.getWbUser().getBirth();

            // 생년월일을 이용해 나이 계산
            Calendar today = Calendar.getInstance();
            Calendar birthCalendar = Calendar.getInstance();
            birthCalendar.setTime(birthDate);

            int age = today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
            if (today.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }

            // DTO 생성
            return ApplicantsDTO.builder()
                    .applicantName(applicant.getWbUser().getName())
                    .applicantGender(applicant.getWbUser().getGender())
                    .applicantAge(age)
                    .build();
        }).collect(Collectors.toList());
    }

    // 5. 지원자 결과 설정
    @Override
    public String setApplicantResult(ApplicantResultReqDTO applicantResultReqDTO) {
        int applyId = applicantResultReqDTO.getApplyId();
        ApplyResult applyResult = applicantResultReqDTO.getApplyResult();

        if(userApplyRepository.setApplicantResult(applyId, applyResult) == 1){
            return "지원자 결과 설정이 완료되었습니다.";
        }else
            return "지원자 결과 설정에 실패했습니다.";
    }

}