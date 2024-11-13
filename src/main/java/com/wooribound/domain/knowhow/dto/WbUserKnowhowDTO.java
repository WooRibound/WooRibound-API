package com.wooribound.domain.knowhow.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WbUserKnowhowDTO {
    private String userName;
    private Long knowhowId;
    private String knowhowJob;
    private String knowhowTitle;
    private String knowhowContent;
    private Date uploadDate;

    @JsonProperty("userName")
    public String getMaskedUserName() {
        if (userName != null && userName.length() > 1) {
            return userName.charAt(0) + "*".repeat(userName.length() - 1);
        }
        return userName;
    }
}
