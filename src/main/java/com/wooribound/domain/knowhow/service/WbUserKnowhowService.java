package com.wooribound.domain.knowhow.service;

import com.wooribound.domain.knowhow.dto.WbUserKnowhowDTO;

import java.util.List;

public interface WbUserKnowhowService {

    List<WbUserKnowhowDTO> getLatest4ShareKnowhows();

    List<WbUserKnowhowDTO> getAllShareKnowhows(String userId, String knowhowTitle, String knowhowJob);

    String deleteShareKnowhow (String userId, Long knowhowId);

    Long createShareKnowhow(String userId, WbUserKnowhowDTO wbUserKnowhowDTO);

    List<WbUserKnowhowDTO> getAllExploreKnowhows(String knowhowTitle, String knowhowJob);

    WbUserKnowhowDTO getShareKnowhowDetail(Long knowhowId);
}
