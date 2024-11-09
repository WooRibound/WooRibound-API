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
  public void saveByJobName(String userId, List<String> jobNames) {
    try {
      jobNames.stream()
          .forEach(jobName -> workHistoryRepository.saveByJobName(userId, jobName));
    } catch (Exception e) {
      throw new NoJobException();
    }
  }
}
