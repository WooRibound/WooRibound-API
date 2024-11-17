package com.wooribound.api.corporate.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Builder
@AllArgsConstructor
@Data
public class JobPostingReqDTO {
    private MultipartFile postImg;
    private String postTitle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private Long jobId;




}
