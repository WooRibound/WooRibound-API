package com.wooribound.domain.workhistory;

import com.wooribound.global.exception.NoJobException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkHistoryServiceImpl implements WorkHistoryService {

  private final WorkHistoryRepository workHistoryRepository;

  @Override
  public void saveByJobName(String userId, List<Long> jobNames) {
    try {
      jobNames.stream()
          .forEach(jobId -> workHistoryRepository.saveByJobName(userId, jobId));
    } catch (Exception e) {
      throw new NoJobException();
    }
  }
}
