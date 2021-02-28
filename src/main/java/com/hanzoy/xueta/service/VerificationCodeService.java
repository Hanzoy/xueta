package com.hanzoy.xueta.service;

public interface VerificationCodeService {
    void sendVerificationCode(String phone);

    boolean checkVerificationCode(String phone, String Code);

    void deleteVerificationCode(String phone);
}
