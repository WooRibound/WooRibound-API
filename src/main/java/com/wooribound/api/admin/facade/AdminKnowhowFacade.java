package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminKnowhowDTO;
import com.wooribound.domain.knowhow.service.AdminKnowhowService;
import com.wooribound.domain.knowhow.dto.KnowhowDTO;
import com.wooribound.domain.knowhow.dto.KnowhowDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AdminKnowhowFacade {

    private final AdminKnowhowService adminKnowhowService;

    public List<KnowhowDTO> getAllKnowhows(AdminKnowhowDTO adminKnowhowDTO) {
        return adminKnowhowService.getAllKnowhows(adminKnowhowDTO);
    }

    public KnowhowDetailDTO getKnowhowDetail(Long knowhowId) {
        return adminKnowhowService.getKnowhowDetail(knowhowId);
    }

    public String deleteKnowhow(Long knowhowId) {
        return adminKnowhowService.deleteKnowhow(knowhowId);
    }
}
