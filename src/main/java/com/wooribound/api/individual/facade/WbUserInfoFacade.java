package com.wooribound.api.individual.facade;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.domain.userapply.DTO.WbUserApplyDTO;
import com.wooribound.domain.userapply.Service.UserApplyService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class WbUserInfoFacade {

    private final UserApplyService userApplyService;

    public WbUserInfoFacade(UserApplyService userApplyService) {
        this.userApplyService = userApplyService;
    }

    public List<WbUserApplyDTO> getUserApplyList(String userId) {
        return userApplyService.getUserApplyList(userId);
    }

    public String cancelUserApply(UserApplyDTO userApplyDTO) {
        String userId = userApplyDTO.getUserId();
        String applyId = userApplyDTO.getApplyId();
        return userApplyService.cancelUserApply(userApplyDTO);
    }


}

