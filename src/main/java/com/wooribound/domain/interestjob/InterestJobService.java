package com.wooribound.domain.interestjob;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface InterestJobService {
  public void saveByJobNameList(List<String> interestJobs, String userId);
}
