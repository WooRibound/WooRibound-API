package com.wooribound.domain.workhistory;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface WorkHistoryService {
  void saveByJobName(String userId, List<Long> jobNames);
}
