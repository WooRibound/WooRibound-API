package com.wooribound.domain.wbuser.service;

import com.wooribound.api.admin.dto.AdminWbUserReqDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.domain.wbuser.dto.AdminIndividualDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminWbUserServiceImpl implements AdminWbUserService {

    private final WbUserRepository wbUserRepository;

    @Override
    public List<AdminIndividualDTO> getWbUsers(AdminWbUserReqDTO adminWbUserReqDTO) {
        String userName = adminWbUserReqDTO.getUserName() != null ? adminWbUserReqDTO.getUserName() : null;
        String addrCity = adminWbUserReqDTO.getAddrCity() != null ? adminWbUserReqDTO.getAddrCity() : null;

        List<WbUser> wbUsers = wbUserRepository.findWbUsers(userName, addrCity);

        return wbUsers.stream().map(wbUser -> AdminIndividualDTO.builder()
                        .name(wbUser.getName())
                        .birth(wbUser.getBirth())
                        .gender(wbUser.getGender())
                        .addrCity(wbUser.getAddrCity())
                        .build())
                .collect(Collectors.toList());
    }
}
