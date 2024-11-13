package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.corporate.dto.ApplicantsDTO;
import com.wooribound.api.corporate.dto.JobPostingReqDTO;
import com.wooribound.domain.enterprise.Enterprise;
import com.wooribound.domain.enterprise.EnterpriseRepository;
import com.wooribound.domain.job.Job;
import com.wooribound.domain.job.JobRepository;
import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.jobposting.JobPostingRepository;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailProjection;
import com.wooribound.domain.notification.Notification;
import com.wooribound.domain.notification.NotificationRepository;
import com.wooribound.domain.userapply.UserApply;
import com.wooribound.domain.userapply.UserApplyRepository;
import com.wooribound.domain.userapply.dto.ApplicantResultReqDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.global.constant.ApplyResult;
import com.wooribound.global.constant.YN;
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
    private final NotificationRepository notificationRepository;
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
                    //   .postState(jobPosting.getPostState())
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
    public List<JobPostingDetailDTO> getJobPostingList(String entId) {
        List<JobPostingDetailProjection> jobPostings = jobPostingRepository.getMyJobPostings(entId);
        return jobPostings.stream().map(jp -> JobPostingDetailDTO.builder()
                        .entAddr1(jp.getEntAddr1())
                        .entAddr2(jp.getEntAddr2())
                        .entName(jp.getEntName())
                        .jobName(jp.getJobName())
                        .postImg(jp.getPostImg())
                        .postTitle(jp.getPostTitle())
                        .startDate(jp.getStartDate())
                        .endDate(jp.getEndDate())
                        .applicantCount(jp.getApplicantCount())
                        .build()
                )
                .collect(Collectors.toList());
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

        if (userApplyRepository.setApplicantResult(applyId, applyResult) == 1) {

            UserApply userApply = userApplyRepository.findById((long)applyId)
                    .orElseThrow(() -> new RuntimeException("지원 정보를 찾을 수 없습니다."));
            WbUser wbUser = userApply.getWbUser();
            String entName = userApply.getJobPosting().getEnterprise().getEntName();

            String applyResultKorean = switch (applyResult.name()) {
                case "PENDING" -> "발표 전";
                case "ACCEPTED" -> "합격";
                case "FAILED" -> "탈락";
                case "CANCELED" -> "지원취소됨";
                default -> "";
            };

            // 알림 생성
            Notification notification = Notification.builder()
                    .wbUser(wbUser)
                    .userApply(userApply)
                    .notice(entName+" 지원결과 : "+ applyResultKorean)
                    .isConfirmed(YN.N)
                    .createdAt(new Date())
                    .build();

            notificationRepository.save(notification);

            return "지원자 결과 설정이 완료되었습니다.";
        } else {
            return "지원자 결과 설정에 실패했습니다.";
        }
    }

    // 6. 공고 직무별 지원자 추천 (헤드헌팅기능)
    @Override
    public List<ApplicantsDTO> getApplicantRecommendation(int jobId) {

        List<WbUser> recommendedUsers = jobPostingRepository.findApplicantRecommendation(jobId);

        return recommendedUsers.stream().map(user -> {
            // 생일 계산
            Date birthDate = user.getBirth();
            Calendar today = Calendar.getInstance();
            Calendar birthCalendar = Calendar.getInstance();
            birthCalendar.setTime(birthDate);

            int age = today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
            if (today.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }

            return ApplicantsDTO.builder()
                    .applicantName(user.getName())
                    .applicantGender(user.getGender())
                    .applicantAge(age)
                    .build();
        }).collect(Collectors.toList());

    }
}