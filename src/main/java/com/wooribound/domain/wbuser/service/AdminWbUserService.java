package com.wooribound.domain.wbuser.service;

import com.wooribound.api.admin.dto.AdminWbUserReqDTO;
import com.wooribound.domain.wbuser.dto.AdminIndividualDTO;

import java.util.List;

public interface AdminWbUserService {

    List<AdminIndividualDTO> getWbUsers(AdminWbUserReqDTO adminWbUserReqDTO);
}
