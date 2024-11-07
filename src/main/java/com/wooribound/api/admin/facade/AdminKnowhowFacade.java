package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminKnowhowReqDTO;
import com.wooribound.domain.knowhow.service.AdminKnowhowService;
import com.wooribound.domain.knowhow.dto.KnowhowDTO;
import com.wooribound.domain.knowhow.dto.KnowhowDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AdminKnowhowFacade {

    private final AdminKnowhowService adminKnowhowService;

    @Transactional(readOnly = true)
    public List<KnowhowDTO> getAllKnowhows(AdminKnowhowReqDTO adminKnowhowReqDTO) {
        return adminKnowhowService.getAllKnowhows(adminKnowhowReqDTO);
    }

    @Transactional(readOnly = true)
    public KnowhowDetailDTO getKnowhowDetail(Long knowhowId) {
        return adminKnowhowService.getKnowhowDetail(knowhowId);
    }

    @Transactional
    public String deleteKnowhow(Long knowhowId) {
        return adminKnowhowService.deleteKnowhow(knowhowId);
    }
}
