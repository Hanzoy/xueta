package com.hanzoy.xueta.dto.param;

import lombok.Data;

@Data
public class ChangePasswordParam {
    private String token;
    private String oldPassword;
    private String newPassword;
}
