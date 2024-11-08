package com.wooribound.domain.enterprise.service;

import com.wooribound.api.admin.dto.AdminEnterpriseReqDTO;
import com.wooribound.domain.enterprise.Enterprise;
import com.wooribound.domain.enterprise.EnterpriseRepository;
import com.wooribound.domain.enterprise.dto.AdminEnterpriseDTO;
import com.wooribound.domain.enterprise.dto.AdminEnterpriseDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminEnterpriseServiceImpl implements AdminEnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    @Override
    public List<AdminEnterpriseDTO> getEnterprises(AdminEnterpriseReqDTO adminEnterpriseReqDTO) {
        String entName = adminEnterpriseReqDTO.getEntName() != null ? adminEnterpriseReqDTO.getEntName() : null;
        String entField = adminEnterpriseReqDTO.getEntField() != null ? adminEnterpriseReqDTO.getEntField() : null;
        String addrCity = adminEnterpriseReqDTO.getAddrCity() != null ? adminEnterpriseReqDTO.getAddrCity() : null;

        List<Enterprise> enterprises = enterpriseRepository.findEnterprises(entName, entField, addrCity);

        return enterprises.stream().map(enterprise -> AdminEnterpriseDTO.builder()
                        .entId(enterprise.getEntId())
                        .entName(enterprise.getEntName())
                        .entField(enterprise.getEntField())
                        .addrCity(enterprise.getEntAddr1())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public AdminEnterpriseDetailDTO getEnterpriseInfo(String entId) {
        Enterprise enterprise = enterpriseRepository.findByEntId(entId);

        return AdminEnterpriseDetailDTO.builder()
                .entId(enterprise.getEntId())
                .ceoName(enterprise.getCeoName())
                .entName(enterprise.getEntName())
                .regNum(enterprise.getRegNum())
                .entAddr1(enterprise.getEntAddr1())
                .entAddr2(enterprise.getEntAddr2())
                .entSize(enterprise.getEntSize())
                .entField(enterprise.getEntField())
                .revenue(enterprise.getRevenue())
                .build();
    }
}
