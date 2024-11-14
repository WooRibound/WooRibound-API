package com.wooribound.domain.knowhow.service;

import com.wooribound.domain.knowhow.Knowhow;
import com.wooribound.domain.knowhow.KnowhowRepository;
import com.wooribound.domain.knowhow.dto.WbUserKnowhowDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.global.exception.KnowhowNotFoundException;
import com.wooribound.global.exception.UnauthorizedAccessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WbUserKnowhowServiceImpl implements WbUserKnowhowService{

    private final KnowhowRepository knowhowRepository;
    private final WbUserRepository wbUserRepository;

    @Override
    public List<WbUserKnowhowDTO> getAllShareKnowhows(String userId, String knowhowTitle, String knowhowJob) {
        List<Knowhow> knowhows = knowhowRepository.findByUserIdAndTermAndFilter(userId, knowhowTitle, knowhowJob);

        return knowhows.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WbUserKnowhowDTO getShareKnowhowDetail(Long knowhowId) {
        Optional<Knowhow> knowhowOptional = knowhowRepository.findById(knowhowId);

        if (knowhowOptional.isEmpty()) {
            throw new KnowhowNotFoundException(String.format("%d는 없는 게시물 입니다.: ", knowhowId));
        }

        Knowhow knowhow = knowhowOptional.get();
        return convertToDTO(knowhow);
    }

    @Override
    public Long deleteShareKnowhow(String userId, Long knowhowId) {
        Optional<Knowhow> byKnowhowId = knowhowRepository.findById(knowhowId);

        if (byKnowhowId.isEmpty()) {
            throw new IllegalArgumentException("없는 지혜 나눔 게시물입니다.");
        }

        Knowhow knowhow = byKnowhowId.get();
        if (knowhow.getWbUser().getUserId().equals(userId)) {
            knowhowRepository.delete(knowhow);
            return knowhowId;
        } else {
            throw new UnauthorizedAccessException();
        }
    }

    @Override
    public Long createShareKnowhow(String userId, WbUserKnowhowDTO wbUserKnowhowDTO) {

        long knowhowId = 1L;

        Optional<WbUser> byUserId = wbUserRepository.findById(userId);
        Optional<Long> maxKnowhowId = knowhowRepository.getMaxKnowhowId();
        if (maxKnowhowId.isPresent()) {
            knowhowId = maxKnowhowId.get() + 1;
        }

        Knowhow knowhow = Knowhow.builder()
                .knowhowId(knowhowId)
                .wbUser(byUserId.get())
                .knowhowJob(wbUserKnowhowDTO.getKnowhowJob())
                .knowhowTitle(wbUserKnowhowDTO.getKnowhowTitle())
                .knowhowContent(wbUserKnowhowDTO.getKnowhowContent())
                .uploadDate(new Date())
                .build();

        Knowhow savedKnowhow =knowhowRepository.save(knowhow);
        return savedKnowhow.getKnowhowId();
    }

    @Override
    public List<WbUserKnowhowDTO> getAllExploreKnowhows(String knowhowTitle, String knowhowJob) {

        List<Knowhow> knowhows = knowhowRepository.findByTermAndFilter(knowhowTitle, knowhowJob);

        return knowhows.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private WbUserKnowhowDTO convertToDTO(Knowhow knowhow) {
        Optional<WbUser> byId = wbUserRepository.findById(knowhow.getWbUser().getUserId());

        WbUserKnowhowDTO dto = WbUserKnowhowDTO.builder()
                .userName(byId.get().getName())
                .knowhowId(knowhow.getKnowhowId())
                .knowhowTitle(knowhow.getKnowhowTitle())
                .knowhowJob(knowhow.getKnowhowJob())
                .knowhowContent(knowhow.getKnowhowContent())
                .uploadDate(knowhow.getUploadDate())
                .build();

        return dto;
    }

}
