package com.wooribound.domain.interestjob;

import com.wooribound.global.exception.NoJobException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InterestJobServiceImpl implements InterestJobService {

  private final InterestJobRepository interestJobRepository;
  @Override
  public void saveByJobNameList(List<String> interestJobs, String userId) {
    // 또는 방법 2: forEach 내부에서 로깅
    try {
      interestJobs.stream()
          .forEach(jobName -> {
            log.info("처리중인 직종명: {}", jobName);
            interestJobRepository.saveInterestJob(userId, jobName);
          });
    } catch (Exception e) {
      log.error("직종 저장 중 오류 발생", e);
      throw new NoJobException();
    }

  }


}
