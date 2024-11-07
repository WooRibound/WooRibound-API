package com.wooribound.domain.userapply.Service;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.jobposting.JobPostingRepository;
import com.wooribound.domain.userapply.DTO.WbUserApplyDTO;
import com.wooribound.domain.userapply.UserApply;
import com.wooribound.domain.userapply.UserApplyRepository;
import com.wooribound.global.constant.ApplyResult;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserApplyServiceImpl implements UserApplyService {

    Logger logger = org.slf4j.LoggerFactory.getLogger(UserApplyServiceImpl.class);

    private final UserApplyRepository userApplyRepository;
    private final JobPostingRepository jobPostingRepository;
    private final com.wooribound.domain.wbuser.WbUserRepository wbUserRepository;

    // 1. 공고 지원
    @Override
    public String createUserApply(UserApplyDTO userApplyDTO) {
        String userId = userApplyDTO.getUserId();
        Long postId = userApplyDTO.getPostId();

        try {
            JobPosting jobPosting = jobPostingRepository.findById(postId)
                    .orElseThrow(() -> new NoSuchElementException("해당 공고 ID가 존재하지 않습니다."));
            com.wooribound.domain.wbuser.WbUser wbUser = wbUserRepository.findById(userId)
                    .orElseThrow(() -> new NoSuchElementException("해당 사용자 ID가 존재하지 않습니다."));

            UserApply userApply = UserApply.builder()
                    .jobPosting(jobPosting)
                    .wbUser(wbUser)
                    .result(ApplyResult.PENDING)
                    .applyDate(new Date())
                    .build();

            userApplyRepository.save(userApply);

            return "지원이 정상적으로 완료되었습니다.";

        } catch (Exception e) {
            logger.error("지원 생성 중 예상치 못한 오류 발생: {}", e.getMessage());
            return "지원 중 오류가 발생했습니다. 다시 시도해 주세요.";
        }
    }

    // 2. 지원 공고 조회
    @Override
    public List<WbUserApplyDTO> getUserApplyList(UserApplyDTO userApplyDTO) {
        String userId = userApplyDTO.getUserId();

        List<UserApply> userApplyList = userApplyRepository.findByWbUser_UserId(userId);

        return userApplyList.stream()
                .map(userApply -> WbUserApplyDTO.builder()
                                    .result(userApply.getResult())
                                    .entName(userApply.getJobPosting().getEnterprise().getEntName())
                                    .postTitle(userApply.getJobPosting().getPostTitle())
                                    .endDate(userApply.getJobPosting().getEndDate())
                                    .entAddr1(userApply.getJobPosting().getEnterprise().getEntAddr1())
                                    .entAddr2(userApply.getJobPosting().getEnterprise().getEntAddr2())
                                    .build())
                .collect(Collectors.toList());
    }
    
    // 3. 지원 공고 취소
    @Override
    public String cancelUserApply(UserApplyDTO userApplyDTO) {
        String userId = userApplyDTO.getUserId();
        String applyId = userApplyDTO.getApplyId();

        UserApply userApply = userApplyRepository.findById(Long.valueOf(applyId))
                .orElseThrow(() -> new RuntimeException("지원 정보를 찾을 수 없습니다."));

        if (!userApply.getWbUser().getUserId().equals(userId)) {
            throw new RuntimeException("해당 사용자의 지원 정보가 아닙니다.");
        }

        userApply.setResult(ApplyResult.CANCELED);
        userApplyRepository.save(userApply);

        return "지원이 정상적으로 취소되었습니다.";
    }
}