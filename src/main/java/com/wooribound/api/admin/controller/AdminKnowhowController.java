package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminKnowhowDTO;
import com.wooribound.api.admin.facade.AdminKnowhowFacade;
import com.wooribound.domain.knowhow.dto.KnowhowDTO;
import com.wooribound.domain.knowhow.dto.KnowhowDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/knowhow/")
public class AdminKnowhowController {
    private final AdminKnowhowFacade adminKnowhowFacade;

    @GetMapping
    public List<KnowhowDTO> getAllKnowhows(@ModelAttribute AdminKnowhowDTO adminKnowhowDTO) {
        return adminKnowhowFacade.getAllKnowhows(adminKnowhowDTO);
    }

    @GetMapping("/detail")
    public KnowhowDetailDTO getKnowhowDetail(@RequestParam Long knowhowId) {
        return adminKnowhowFacade.getKnowhowDetail(knowhowId);
    }

    @PostMapping("/delete")
    public String deleteKnowhow(@RequestParam Long knowhowId) {
        return adminKnowhowFacade.deleteKnowhow(knowhowId);
    }
}
