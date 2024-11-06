package com.wooribound.domain.knowhow.service;

import com.wooribound.api.admin.dto.AdminKnowhowDTO;
import com.wooribound.domain.knowhow.dto.KnowhowDTO;
import com.wooribound.domain.knowhow.dto.KnowhowDetailDTO;

import java.util.List;

public interface AdminKnowhowService {
    List<KnowhowDTO> getAllKnowhows(AdminKnowhowDTO adminKnowhowDTO);

    KnowhowDetailDTO getKnowhowDetail(Long knowhowId);

    String deleteKnowhow(Long knowhowId);
}
