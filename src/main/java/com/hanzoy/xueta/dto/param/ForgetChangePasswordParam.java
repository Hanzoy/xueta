package com.hanzoy.xueta.dto.param;

import lombok.Data;

@Data
public class ForgetChangePasswordParam {
    private String token;
    private String password;
}
