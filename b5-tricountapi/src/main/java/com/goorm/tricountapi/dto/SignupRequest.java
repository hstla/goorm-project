package com.goorm.tricountapi.dto;

import com.goorm.tricountapi.model.Member;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignupRequest {
    @NotNull
    private String loginId;
    @NotNull
    private String password;
    @NotNull
    private String name;

    public  Member toMember() {
        return Member.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .build();
    }
}
