package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.admin.dto.AdminJobPostingReqDTO;
import com.wooribound.api.individual.dto.JobPostingProjection;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.jobposting.JobPostingRepository;
import com.wooribound.domain.notification.Notification;
import com.wooribound.domain.notification.NotificationRepository;
import com.wooribound.domain.userapply.UserApply;
import com.wooribound.domain.userapply.UserApplyRepository;
import com.wooribound.global.constant.YN;
import com.wooribound.global.exception.NoJobPostingException;
import com.wooribound.global.exception.NoUserApplyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminJobPostingServiceImpl implements AdminJobPostingService {

    private final JobPostingRepository jobPostingRepository;
    private final UserApplyRepository userApplyRepository;
    private final NotificationRepository notificationRepository;

    @Override
    public List<JobPostingDTO> getAllJobPostings(AdminJobPostingReqDTO adminJobPostingReqDTO) {
        List<JobPostingProjection> jobPostings = jobPostingRepository.findJobPostings(adminJobPostingReqDTO.getEntName(), adminJobPostingReqDTO.getJobName(), adminJobPostingReqDTO.getAddrCity());

        return jobPostings.stream().map(job -> JobPostingDTO.builder().jobPostingId(job.getPostId()).entName(job.getEnterprise().getEntName()).postTitle(job.getPostTitle()).startDate(job.getStartDate()).endDate(job.getEndDate()).entAddr1(job.getEnterprise().getEntAddr1()).postState(job.getPostState()).build()).collect(Collectors.toList());
    }

    @Override
    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        try {
            JobPosting jobPosting = jobPostingRepository.findJobPostingByPostId(postId);

            if (jobPosting == null) {
                throw new NoJobPostingException("해당 공고 ID를 찾을 수 없습니다: " + postId);
            }

            return JobPostingDetailDTO.builder()
                    .postTitle(jobPosting.getPostTitle())
                    .entName(jobPosting.getEnterprise().getEntName())
                    .postImg(jobPosting.getPostImg())
                    .startDate(jobPosting.getStartDate())
                    .endDate(jobPosting.getEndDate())
                    .jobName(jobPosting.getJob().getJobName())
                    .entAddr1(jobPosting.getEnterprise().getEntAddr1())
                    .build();
        } catch (Exception e) {
            throw new NoJobPostingException("채용공고 정보를 가져오는 도중 에러가 발생했습니다: " + postId, e);
        }
    }

    @Override
    public String deleteJobPosting(Long postId) {
        JobPosting jobPosting = jobPostingRepository.findJobPostingByPostId(postId);

        if (jobPostingRepository.updateIsDeletedByPostId(postId) != 0) {
            try {
                List<UserApply> userApplies = userApplyRepository.findUserApply(postId);

                if (userApplies.isEmpty()) {
                    throw new NoUserApplyException(postId);  // 지원자가 없을 경우 예외 던짐
                }

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