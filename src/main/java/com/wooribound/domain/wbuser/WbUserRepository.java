package com.wooribound.domain.wbuser;

import com.wooribound.global.constant.YN;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WbUserRepository extends JpaRepository<WbUser, String> {

    Optional<WbUser> findByUserId(String userId);

    @Query("SELECT w FROM WbUser w " +
            "WHERE (:userName IS NULL OR w.name LIKE CONCAT('%', :userName, '%')) " +
            "AND (:addrCity IS NULL OR w.addrCity = :addrCity)")
    List<WbUser> findWbUsers(@Param("userName") String userName,
                             @Param("addrCity") String addrCity);

}

