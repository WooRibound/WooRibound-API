package com.wooribound.domain.individual.repository;

import com.wooribound.domain.individual.entity.InterestJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestJobRepository extends JpaRepository<InterestJob, Long> {

}
