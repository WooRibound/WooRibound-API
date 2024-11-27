package com.wooribound.domain.userapply.Service;

import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.jobposting.JobPostingRepository;
import com.wooribound.domain.resume.Resume;
import com.wooribound.domain.resume.ResumeRepository;
import com.wooribound.domain.userapply.UserApply;
import com.wooribound.domain.userapply.UserApplyRepository;
import com.wooribound.domain.userapply.dto.WbUserApplyDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.global.constant.ApplyResult;
import com.wooribound.global.exception.NotEntityException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserApplyServiceImpl implements UserApplyService {

    private final UserApplyRepository userApplyRepository;
    private final JobPostingRepository jobPostingRepository;
    private final ResumeRepository resumeRepository;
    private final WbUserRepository wbUserRepository;

    // 1. 공고 지원
    @Override
    public String createUserApply(String userId, Long postId) {
        try {
            JobPosting jobPosting = jobPostingRepository.findById(postId)
                    .orElseThrow(() -> new NoSuchElementException("해당 공고 ID가 존재하지 않습니다."));
            WbUser wbUser = wbUserRepository.findById(userId)
                    .orElseThrow(() -> new NoSuchElementException("해당 사용자 ID가 존재하지 않습니다."));
            Optional<Resume> resume = resumeRepository.findByUserId(userId);

            if (resume.isEmpty()) {
                return "이력서를 등록하고 지원해주세요.";
            }

            Optional<UserApply> byIdUserApply = userApplyRepository.findById(postId);

            if (byIdUserApply.isPresent()) {
                return "이미 지원하신 채용공고입니다.";
            } else {
                long userApplyId = 1L;
                Optional<Long> maxUserApplyId = userApplyRepository.getMaxUserApplyId();
                if (maxUserApplyId.isPresent()) {
                    userApplyId = maxUserApplyId.get() + 1;
                }

                UserApply userApply = UserApply.builder()
                        .applyId(userApplyId)
                        .jobPosting(jobPosting)
                        .wbUser(wbUser)
                        .result(ApplyResult.PENDING)
                        .applyDate(new Date())
                        .build();

                userApplyRepository.save(userApply);
                return "지원이 정상적으로 완료되었습니다.";
            }

        } catch (Exception e) {
            log.error("지원 생성 중 예상치 못한 오류 발생: {}", e.getMessage());
            return "지원 중 오류가 발생했습니다. 다시 시도해 주세요.";
        }
    }

    @Override
    public WbUserApplyDTO getUserApplyDetail(String userId, Long applyId) {
        wbUserRepository.findById(userId)
                .orElseThrow(() -> new NotEntityException("[WbUser, ID :" + userId + "]"));

        UserApply userApply = userApplyRepository.findById(applyId).
                orElseThrow(() -> new NotEntityException("[UserApply, ID :" + applyId + "]"));

        return WbUserApplyDTO.builder()
                .applyId(userApply.getApplyId())
                .result(userApply.getResult())
                .postId(userApply.getJobPosting().getPostId())
                .postTitle(userApply.getJobPosting().getPostTitle())
                .postImg(userApply.getJobPosting().getPostImg())
                .jobName(userApply.getJobPosting().getJob().getJobName())
                .startDate(userApply.getJobPosting().getStartDate())
                .endDate(userApply.getJobPosting().getEndDate())
                .entName(userApply.getJobPosting().getEnterprise().getEntName())
                .entAddr1(userApply.getJobPosting().getEnterprise().getEntAddr1())
                .entAddr2(userApply.getJobPosting().getEnterprise().getEntAddr2())
                .build();
    }

    // 2. 지원 공고 조회
    @Override
    public List<WbUserApplyDTO> getUserApplyList(String userId) {

        List<UserApply> userApplyList = userApplyRepository.findByWbUser_UserId(userId);

        return userApplyList.stream()
                .map(userApply -> WbUserApplyDTO.builder()
                                    .applyId(userApply.getApplyId())
                                    .result(userApply.getResult())
                                    .entName(userApply.getJobPosting().getEnterprise().getEntName())
                                    .postTitle(userApply.getJobPosting().getPostTitle())
                                    .postId(userApply.getJobPosting().getPostId())
                                    .startDate(userApply.getJobPosting().getStartDate())
                                    .endDate(userApply.getJobPosting().getEndDate())
                                    .entAddr1(userApply.getJobPosting().getEnterprise().getEntAddr1())
                                    .entAddr2(userApply.getJobPosting().getEnterprise().getEntAddr2())
                                    .build())
                .collect(Collectors.toList());
    }

    // 3. 지원 공고 취소
    @Override
    public String cancelUserApply(String userId, Long applyId) {
        UserApply userApply = userApplyRepository.findById(applyId)
                .orElseThrow(() -> new RuntimeException("지원 정보를 찾을 수 없습니다."));

        if (!userApply.getWbUser().getUserId().equals(userId)) {
            throw new RuntimeException("해당 사용자의 지원 정보가 아닙니다.");
        }

        if (userApply.getResult().equals(ApplyResult.CANCELED)){
            return "이미 지원 취소한 공고입니다.";
        } else {
            userApply.setResult(ApplyResult.CANCELED);
            userApplyRepository.save(userApply);

            return "지원이 정상적으로 취소되었습니다.";
        }
    }
}