package com.hanzoy.xueta.dto.param;

import lombok.Data;

@Data
public class RegisterParam {
    private String username;
    private String password;
    private String phone;
    private String verification;
}
