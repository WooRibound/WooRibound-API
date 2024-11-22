package com.wooribound.domain.knowhowreported.service;

import com.wooribound.domain.knowhow.Knowhow;
import com.wooribound.domain.knowhow.KnowhowRepository;
import com.wooribound.domain.knowhowreported.KnowhowReported;
import com.wooribound.domain.knowhowreported.KnowhowReportedRepository;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.global.exception.NotEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KnowhowReportedServiceImpl implements KnowhowReportedService{

    private final WbUserRepository wbUserRepository;
    private final KnowhowRepository knowhowRepository;
    private final KnowhowReportedRepository knowhowReportedRepository;

    @Override
    public String reportKnowhow(String userId, Long knowhowId) {
        wbUserRepository.findById(userId)
                .orElseThrow(() -> new NotEntityException("[WbUser, ID :" + userId + "]"));

        Knowhow knowhow = knowhowRepository.findById(knowhowId)
                .orElseThrow(() -> new NotEntityException("[Knowhow, ID :" + knowhowId + "]"));

        if (userId.equals(knowhow.getWbUser().getUserId())) {
            return "본인이 작성한 글은 신고할 수 없습니다.";
        }

        Long reportedId = knowhowReportedRepository.getMaxReportedId().orElse(0L) + 1;

        KnowhowReported knowhowReported = KnowhowReported.builder()
                .reportedId(reportedId)
                .wbUser(knowhow.getWbUser())
                .knowhow(knowhow)
                .build();

        knowhowReportedRepository.save(knowhowReported);

        return "신고하기가 완료되었습니다.";
    }
}
