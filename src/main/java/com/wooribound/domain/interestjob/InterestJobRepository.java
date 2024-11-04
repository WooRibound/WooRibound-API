package com.wooribound.domain.interestjob;

import com.wooribound.domain.interestjob.InterestJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestJobRepository extends JpaRepository<InterestJob, Long> {

}
