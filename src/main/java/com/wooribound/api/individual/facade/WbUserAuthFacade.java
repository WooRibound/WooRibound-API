package com.wooribound.api.individual.facade;

import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserJoinInfoResDTO;
import com.wooribound.api.individual.dto.WbUserJoinReqDTO;
import com.wooribound.api.individual.dto.WbUserUpdateDTO;
import com.wooribound.domain.interestjob.InterestJobService;
import com.wooribound.domain.wbuser.WbUserService;
import com.wooribound.domain.workhistory.WorkHistoryRepository;
import com.wooribound.domain.workhistory.WorkHistoryService;
import com.wooribound.global.constant.YN;
import com.wooribound.global.exception.SaveInterestingJobException;
import com.wooribound.global.exception.SaveWorkHistoryException;
import com.wooribound.global.exception.UpdateUserInfoException;
import com.wooribound.global.util.AuthenticateUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class WbUserAuthFacade {
  private final WbUserService wbUserService;
  private final InterestJobService interestJobService;
  private final AuthenticateUtil authenticateUtil;
  private final WorkHistoryService workHistoryService;


  public WbUserJoinInfoResDTO getJoinInfo(Authentication authentication){
    String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
    WbUserDTO wbUserDTO = wbUserService.getOneUserInfo(userId);


    return WbUserJoinInfoResDTO.builder()
        .name(wbUserDTO.getName())
        .email(wbUserDTO.getEmail())
        .phone(wbUserDTO.getPhone())
        .gender(wbUserDTO.getGender())
        .birth(wbUserDTO.getBirth())
        .build();
  }

  @Transactional
  public String join(Authentication authentication, @RequestBody WbUserJoinReqDTO wbUserJoinReqDTO){
    String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
    YN isSelectInterested;
    YN isExJobSelected;
    List<String> selectedInterestJobs = wbUserJoinReqDTO.getSelectedInterestJobs();
    List<String> selectedJobs = wbUserJoinReqDTO.getSelectedJobs();
    if (selectedInterestJobs == null ||selectedInterestJobs.isEmpty()){
      isSelectInterested = YN.N;
      System.out.println("관심직종이 비어있습니다.");
    } else {
      isSelectInterested = YN.Y;
    }

    if (selectedJobs == null ||selectedJobs.isEmpty()){
      isExJobSelected = YN.N;
      System.out.println("관심직종이 비어있습니다.");
    } else {
      isExJobSelected = YN.Y;
    }

    try {
      WbUserUpdateDTO wbUserUpdateDTO = WbUserUpdateDTO.builder()
          .userId(userId)
          .name(wbUserJoinReqDTO.getName())
          .addrCity(wbUserJoinReqDTO.getCity())
          .addrProvince(wbUserJoinReqDTO.getProvince())
          .exjobChk(wbUserJoinReqDTO.getIsExperienced())
          .jobInterest(isSelectInterested)
          .phone(wbUserJoinReqDTO.getPhone())
          .birth(wbUserJoinReqDTO.getBirth())
          .gender(wbUserJoinReqDTO.getGender())
          .build();

      wbUserService.updateUserInfo(wbUserUpdateDTO);
    } catch (Exception e) {
      System.out.println();
      throw new UpdateUserInfoException();
    }


    if (isExJobSelected == YN.Y) {
      try {
        workHistoryService.saveByJobName(userId, selectedJobs);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        throw new SaveWorkHistoryException();
      }
    }

    if (isSelectInterested == YN.Y) {
      try {
        interestJobService.saveByJobNameList(selectedInterestJobs, userId);
      } catch (Exception e) {
        throw new SaveInterestingJobException();
      }
      return "회원 가입이 완료되었습니다.";
    }
    return "회원가입이 완료되었습니다.";
  }

}
