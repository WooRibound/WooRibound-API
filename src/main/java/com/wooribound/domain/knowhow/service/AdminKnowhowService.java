package com.wooribound.domain.knowhow.service;

import com.wooribound.api.admin.dto.AdminKnowhowReqDTO;
import com.wooribound.domain.knowhow.dto.AdminKnowhowDTO;
import com.wooribound.domain.knowhow.dto.AdminKnowhowDetailDTO;

import java.util.List;

public interface AdminKnowhowService {
    List<AdminKnowhowDTO> getAllKnowhows(AdminKnowhowReqDTO adminKnowhowDTO);

    AdminKnowhowDetailDTO getKnowhowDetail(Long knowhowId);

    String deleteKnowhow(Long knowhowId);
}
