package com.wooribound.domain.job;

import com.wooribound.domain.interestjob.InterestJob;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
  Optional<Job> findByJobName(String name);
}
