package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminKnowhowReqDTO;
import com.wooribound.api.admin.facade.AdminKnowhowFacade;
import com.wooribound.domain.knowhow.dto.AdminKnowhowDTO;
import com.wooribound.domain.knowhow.dto.AdminKnowhowDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/knowhow")
public class AdminKnowhowController {
    private final AdminKnowhowFacade adminKnowhowFacade;

    @GetMapping
    public List<AdminKnowhowDTO> getAllKnowhows(@ModelAttribute AdminKnowhowReqDTO adminKnowhowReqDTO) {
        return adminKnowhowFacade.getAllKnowhows(adminKnowhowReqDTO);
    }

    @GetMapping("/detail")
    public AdminKnowhowDetailDTO getKnowhowDetail(@RequestParam Long knowhowId) {
        return adminKnowhowFacade.getKnowhowDetail(knowhowId);
    }

    @DeleteMapping("/delete")
    public String deleteKnowhow(@RequestParam Long knowhowId) {
        return adminKnowhowFacade.deleteKnowhow(knowhowId);
    }
}
