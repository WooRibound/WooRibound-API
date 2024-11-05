package com.wooribound.domain.knowhow;

import com.wooribound.api.admin.dto.AdminKnowhowDTO;
import com.wooribound.domain.knowhow.dto.KnowhowDTO;
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
}
