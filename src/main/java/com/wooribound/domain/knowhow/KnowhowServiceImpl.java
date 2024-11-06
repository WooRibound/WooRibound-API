package com.wooribound.domain.knowhow;

import com.wooribound.api.admin.dto.AdminKnowhowDTO;
import com.wooribound.domain.knowhow.dto.KnowhowDTO;
import com.wooribound.domain.knowhow.dto.KnowhowDetailDTO;
import com.wooribound.global.exception.NoKnowhowException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class KnowhowServiceImpl implements KnowhowService {

    private final KnowhowRepository knowhowRepository;

    @Override
    public List<KnowhowDTO> getAllKnowhows(AdminKnowhowDTO adminKnowhowDTO) {
        List<Knowhow> knowhows = knowhowRepository.findAll(adminKnowhowDTO.getKnowhowJob(), adminKnowhowDTO.getKnowhowTitle());

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
