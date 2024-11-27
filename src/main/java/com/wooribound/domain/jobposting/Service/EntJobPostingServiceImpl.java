package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.corporate.dto.ApplicantsDTO;
import com.wooribound.api.corporate.dto.JobPostingReqDTO;
import com.wooribound.api.corporate.dto.RecommendationHistoryDTO;
import com.wooribound.domain.employment.Employment;
import com.wooribound.domain.enterprise.Enterprise;
import com.wooribound.domain.enterprise.EnterpriseRepository;
import com.wooribound.domain.enterprise.dto.UserApplyProjection;
import com.wooribound.domain.job.Job;
import com.wooribound.domain.job.JobRepository;
import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.jobposting.JobPostingRepository;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailProjection;
import com.wooribound.domain.jobposting.dto.WbUserProjection;
import com.wooribound.domain.notification.Notification;
import com.wooribound.domain.notification.NotificationRepository;
import com.wooribound.domain.userapply.UserApply;
import com.wooribound.domain.userapply.UserApplyRepository;
import com.wooribound.domain.userapply.dto.ApplicantResultReqDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.global.constant.ApplyResult;
import com.wooribound.global.constant.YN;
import com.wooribound.global.exception.NoJobPostingException;
import com.wooribound.global.exception.NoUserApplyException;
import com.wooribound.global.exception.NotEntityException;
import com.wooribound.global.util.S3Util;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class EntJobPostingServiceImpl implements EntJobPostingService {
    @Value("${aws.s3.jobPosting.folder}")
    String jobPostingFolderName;

    private final S3Util s3Util;

    private final JobPostingRepository jobPostingRepository;
    private final JobRepository jobRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final UserApplyRepository userApplyRepository;
    private final NotificationRepository notificationRepository;

    // 1. 공고 등록
    @Override
    public String createJobPosting(String entId, JobPostingReqDTO jobPostingReqDTO) {

        Enterprise enterprise = enterpriseRepository.findById(entId).orElse(null);

        Optional<Job> byIdJob = jobRepository.findById(jobPostingReqDTO.getJobId());
        if (byIdJob.isEmpty()) {
            throw new EntityNotFoundException();
        }

        Long jobPostingId = 1L;
        Optional<Long> maxJobPostingId = jobPostingRepository.getMaxJobPostingId();
        if (maxJobPostingId.isPresent()) {
            jobPostingId = maxJobPostingId.get() + 1;
        }

        String imageURL = s3Util.uploadFile(jobPostingReqDTO.getPostImg(), jobPostingFolderName);

        JobPosting jobPosting = JobPosting.builder()
                .postId(jobPostingId)
                .enterprise(enterprise)
                .job(byIdJob.get())
                .postTitle(jobPostingReqDTO.getPostTitle())
                .postImg(imageURL)
                .startDate(jobPostingReqDTO.getStartDate())
                .endDate(jobPostingReqDTO.getEndDate())
                .isDeleted(YN.N)
                .build();

        jobPostingRepository.save(jobPosting);
        return "공고 등록이 완료되었습니다.";
    }

    // 2. 공고 상세
    @Override
    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        // log4j - 공고 상세 조회 시작 로그
        log.info("공고 상세 조회 요청 - ID: {}", postId);

        Optional<JobPosting> jobPostingOptional = jobPostingRepository.findById(postId);
        if (jobPostingOptional.isPresent()) {
            JobPosting jobPosting = jobPostingOptional.get();

            // log4j - 조회된 공고 상세 로그
            log.info("공고 상세 조회 결과 - ID: {}, Title: {}, entName: {}, postImg: {}, startDate: {}, endDate: {}, jobName: {}, entAddr1: {}, entAddr2: {}",
                    jobPosting.getPostId(), jobPosting.getPostTitle(), jobPosting.getEnterprise().getEntName(), jobPosting.getPostImg(), jobPosting.getStartDate(), jobPosting.getEndDate(), jobPosting.getJob().getJobName(), jobPosting.getEnterprise().getEntAddr1(), jobPosting.getEnterprise().getEntAddr2());
            return JobPostingDetailDTO.builder()
                    .postTitle(jobPosting.getPostTitle())
                    .entName(jobPosting.getEnterprise().getEntName())
                    .postImg(jobPosting.getPostImg())
                    .startDate(jobPosting.getStartDate())
                    .endDate(jobPosting.getEndDate())
                    .jobName(jobPosting.getJob().getJobName())
                    .entAddr1(jobPosting.getEnterprise().getEntAddr1())
                    .entAddr2(jobPosting.getEnterprise().getEntAddr2())
                    .jobId(jobPosting.getJob().getJobId())
                    .build();
        } else {
            // 공고가 존재하지 않는 경우 예외 로그
            log.error("공고가 존재하지 않습니다 - ID: {}", postId);
            // 공고가 존재하지 않는 경우 예외 처리
            throw new RuntimeException("해당 공고 없음: " + postId);
        }
    }

    // 3. 내 기업 공고 목록 조회
    @Override
    public List<JobPostingDetailDTO> getJobPostingList(String entId) {
        log.info(entId + "  - 내 기업 공고 목록 조회 시작");
        List<JobPostingDetailProjection> jobPostings = jobPostingRepository.getMyJobPostings(entId);
        List<JobPostingDetailDTO> response = jobPostings.stream().map(jp -> JobPostingDetailDTO.builder()
                        .postId(jp.getPostId())
                        .entAddr1(jp.getEntAddr1())
                        .entAddr2(jp.getEntAddr2())
                        .entName(jp.getEntName())
                        .jobName(jp.getJobName())
                        .postImg(jp.getPostImg())
                        .postTitle(jp.getPostTitle())
                        .startDate(jp.getStartDate())
                        .endDate(jp.getEndDate())
                        .applicantCount(jp.getApplicantCount())
                        .postState(jp.getPostState())
                        .build()
                )
                .collect(Collectors.toList());
        log.info(response.toString());
        return response;
    }

    // 4. 공고 지원자 전체 조회
    @Override
    public List<ApplicantsDTO> getJobApplicants(int postId) {
        List<UserApplyProjection> applicants = userApplyRepository.findByJobPosting_PostId(postId);

        return applicants.stream().map(applicant -> {
            // 개별 지원자의 생년월일 가져오기
            Date birthDate = applicant.getBirth();

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
                    .userId(applicant.getUserId())
                    .applicantName(applicant.getName())
                    .applicantGender(applicant.getGender())
                    .applicantAge(age)
                    .applyId(applicant.getApplyId())
                    .result(applicant.getResult())
                    .recommendCount(applicant.getRecommendCount())
                    .build();
        }).collect(Collectors.toList());
    }

    // 5. 지원자 결과 설정
    @Override
    public String setApplicantResult(ApplicantResultReqDTO applicantResultReqDTO) {
        Long applyId = applicantResultReqDTO.getApplyId();
        ApplyResult applyResult = applicantResultReqDTO.getApplyResult();

        log.info("지원자 결과 설정 START, applyId: {}, applyResult: {}", applyId, applyResult);
        if (userApplyRepository.setApplicantResult(applyId, applyResult) == 1) {

            UserApply userApply = userApplyRepository.findById((long)applyId)
                    .orElseThrow(() -> new RuntimeException("지원 정보를 찾을 수 없습니다."));
            WbUser wbUser = userApply.getWbUser();
            String entName = userApply.getJobPosting().getEnterprise().getEntName();

            String applyResultKorean = switch (applyResult.name()) {
                case "PENDING" -> "발표 전";
                case "ACCEPTED" -> "합격";
                case "REJECTED" -> "탈락";
                case "CANCELED" -> "지원취소됨";
                default -> "";
            };

            Long maxId = notificationRepository.findMaxId();
            Long nextId = maxId + 1;
            log.info("nextId: {}", nextId.toString());

            // 알림 생성
            log.info("알림 생성 시작");
            Notification notification = Notification.builder()
                    .notiId(nextId)
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

        log.info("공고 직무별 지원자 추천 시작 - jobId: {}", jobId);
        List<WbUserProjection> recommendedUsers = jobPostingRepository.findApplicantRecommendation(jobId);

        return recommendedUsers.stream()
                .limit(10)
                .map(user -> {
                    Date birthDate = user.getBirth();
                    Integer age = null;

                    if (birthDate != null) {
                        Calendar today = Calendar.getInstance();
                        Calendar birthCalendar = Calendar.getInstance();
                        birthCalendar.setTime(birthDate);

                        age = today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
                        if (today.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
                            age--;
                        }
                    }

                    Integer recommendCount = (user.getRecommendCount() != null) ? user.getRecommendCount() : 0;

                    return ApplicantsDTO.builder()
                            .applicantName(user.getName())
                            .applicantGender(user.getGender())
                            .applicantAge(age != null ? age : 0) // 나이가 null인 경우 기본값 0 설정
                            .userId(user.getUserId())
                            .recommendCount(recommendCount)
                            .build();
                })
                .collect(Collectors.toList());
    }


    // 6-1. 기업 추천 내역 조회 (프리미엄 기능)
    @Override
    public List<RecommendationHistoryDTO> getRecommendationHistory(String userId) {
        List<Employment> histories = jobPostingRepository.findRecommendationHistory(userId);

        return histories.stream()
                .map(history -> RecommendationHistoryDTO.builder()
                    .entName(history.getEnterprise().getEntName())
                    .build())
         .collect(Collectors.toList());
    }

    @Override
    public String deleteJobPosting(String userId, Long postId) {
        enterpriseRepository.findById(userId)
                .orElseThrow(() -> new NotEntityException("[Enterprise, ID :" + userId + "]"));

        Optional <JobPosting> optionalJobPosting = jobPostingRepository.findJobPostingByPostId(postId);

        if (jobPostingRepository.updateIsDeletedByPostId(postId) != 0) {
            try {
                List<UserApply> userApplies = userApplyRepository.findUserApply(postId);

                if (userApplies.isEmpty()) {
                    throw new NoUserApplyException(postId);  // 지원자가 없을 경우 예외 던짐
                }

                JobPosting jobPosting = optionalJobPosting.get();

                for (UserApply userApply : userApplies) {
                    Notification notification = Notification.builder()
                            .wbUser(userApply.getWbUser())
                            .userApply(userApply)
                            .notice(userApply.getWbUser().getName() + "님께서 지원하신 " +
                                    jobPosting.getEnterprise().getEntName() + " 기업의 " +
                                    jobPosting.getPostTitle() + " 채용공고가 삭제되어 지원 취소 처리 되었습니다." +
                                    "\n 불편을 드려 죄송합니다.")
                            .isConfirmed(YN.N)
                            .createdAt(new Date())
                            .build();

                    notificationRepository.save(notification);
                }
                int updatedCnt = userApplyRepository.cancelUserApplyByPostId(postId);

                return postId + "번 채용공고를 성공적으로 삭제 처리했습니다.";
            } catch (NoUserApplyException e) {
                return "채용공고는 삭제되었지만, 해당 공고에 지원자가 없어 지원 취소 알림은 없습니다.";
            }
        } else {
            throw new NoJobPostingException(postId);  // 채용공고 삭제 실패 시 예외 처리
        }
    }
}