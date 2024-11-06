package com.wooribound.domain.knowhow.service;

import com.wooribound.api.admin.dto.AdminKnowhowReqDTO;
import com.wooribound.domain.knowhow.Knowhow;
import com.wooribound.domain.knowhow.KnowhowRepository;
import com.wooribound.domain.knowhow.dto.KnowhowDTO;
import com.wooribound.domain.knowhow.dto.KnowhowDetailDTO;
import com.wooribound.global.exception.NoKnowhowException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminKnowhowServiceImpl implements AdminKnowhowService {

    private final KnowhowRepository knowhowRepository;

    @Override
    public List<KnowhowDTO> getAllKnowhows(AdminKnowhowReqDTO adminKnowhowReqDTO) {
        List<Knowhow> knowhows = knowhowRepository.findAll(adminKnowhowReqDTO.getKnowhowJob(), adminKnowhowReqDTO.getKnowhowTitle());

        return knowhows.stream().map(knowhow -> KnowhowDTO.builder()
                        .knowhowJob(knowhow.getKnowhowJob())
                        .knowhowTitle(knowhow.getKnowhowTitle())
                        .uploadDate(knowhow.getUploadDate())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public KnowhowDetailDTO getKnowhowDetail(Long knowhowId) {
        Knowhow knowhow = knowhowRepository.findByKnowhowId(knowhowId)
                .orElseThrow((NoKnowhowException::new));

        return KnowhowDetailDTO.builder()
                .knowhowId(knowhow.getKnowhowId())
                .knowhowJob(knowhow.getKnowhowJob())
                .knowhowTitle(knowhow.getKnowhowTitle())
                .knowhowContent(knowhow.getKnowhowContent())
                .uploadDate(knowhow.getUploadDate())
                .userId(knowhow.getWbUser().getUserId())
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
