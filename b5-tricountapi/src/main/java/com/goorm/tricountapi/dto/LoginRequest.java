package com.goorm.tricountapi.dto;

import com.goorm.tricountapi.model.Member;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {
    @NotNull
    private String loginId;
    @NotNull
    private String password;

}
