package com.wooribound.domain.knowhow.service;

import com.wooribound.api.admin.dto.AdminKnowhowReqDTO;
import com.wooribound.domain.knowhow.KnowhowRepository;
import com.wooribound.domain.knowhow.dto.AdminKnowhowDTO;
import com.wooribound.domain.knowhow.dto.AdminKnowhowDetailDTO;
import com.wooribound.domain.knowhow.dto.AdminKnowhowDetailProjection;
import com.wooribound.domain.knowhow.dto.AdminKnowhowProjection;
import com.wooribound.global.exception.NoKnowhowException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminKnowhowServiceImpl implements AdminKnowhowService {

    private final KnowhowRepository knowhowRepository;

    public List<AdminKnowhowDTO> getAllKnowhows(AdminKnowhowReqDTO adminKnowhowReqDTO) {
        String knowhowTitle = adminKnowhowReqDTO.getKnowhowTitle();
        String knowhowJob = adminKnowhowReqDTO.getKnowhowJob();
        String knowhowReport = adminKnowhowReqDTO.getKnowhowReport();

        List<AdminKnowhowProjection> knowhows;

        if ("desc".equals(knowhowReport)) {
            knowhows = knowhowRepository.findAllWithReportedCntDesc(knowhowTitle, knowhowJob);
        } else if ("asc".equals(knowhowReport)) {
            knowhows = knowhowRepository.findAllWithReportedCntAsc(knowhowTitle, knowhowJob);
        } else {
            knowhows = knowhowRepository.findAllWithUploadDateDesc(knowhowTitle, knowhowJob);
        }

        return knowhows.stream().map(projection -> {
            return AdminKnowhowDTO.builder()
                    .knowhowId(projection.getKnowhowId())
                    .userId(projection.getUserId())
                    .knowhowJob(projection.getKnowhowJob())
                    .knowhowTitle(projection.getKnowhowTitle())
                    .uploadDate(projection.getUploadDate())
                    .reportedCnt(projection.getReportedCnt().intValue())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public AdminKnowhowDetailDTO getKnowhowDetail(Long knowhowId) {
        AdminKnowhowDetailProjection knowhow = knowhowRepository.findByKnowhowId(knowhowId)
                .orElseThrow((NoKnowhowException::new));

        return AdminKnowhowDetailDTO.builder()
                .knowhowId(knowhow.getKnowhowId())
                .userId(knowhow.getUserId())
                .userName(knowhow.getUserName())
                .knowhowJob(knowhow.getKnowhowJob())
                .knowhowTitle(knowhow.getKnowhowTitle())
                .knowhowContent(knowhow.getKnowhowContent())
                .uploadDate(knowhow.getUploadDate())
                .reportedCnt(knowhow.getReportedCnt().intValue())
                .build();
    }

    @Override
    public String deleteKnowhow(Long knowhowId) {
        if (knowhowRepository.deleteByKnowhowId(knowhowId) != 0) {
            return knowhowId + "번 노하우를 성공적으로 삭제했습니다.";
        } else {
            throw new NoKnowhowException(knowhowId);
        }
    }
}
