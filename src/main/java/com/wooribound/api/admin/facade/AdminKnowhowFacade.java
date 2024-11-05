package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminKnowhowDTO;
import com.wooribound.domain.knowhow.KnowhowService;
import com.wooribound.domain.knowhow.dto.KnowhowDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AdminKnowhowFacade {

    private final KnowhowService knowhowService;

    public List<KnowhowDTO> getAllKnowhows(AdminKnowhowDTO adminKnowhowDTO) {
        return knowhowService.getAllKnowhows(adminKnowhowDTO);
    }
}
