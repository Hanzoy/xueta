package com.hanzoy.xueta.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResult<T> {
    private String code;
    private String message;
    private T data;

    public CommonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> CommonResult<T> success(String code, String message, T data){
        return new CommonResult<T>(code, message, data);
    }

    public static <T> CommonResult<T> success(String code, String message){
        return success(code, message, null);
    }

    public static <T> CommonResult<T> fail(String code, String message, T data){
        return new CommonResult<T>(code, message, data);
    }

    public static <T> CommonResult<T> fail(String code, String message){
        return fail(code, message, null);
    }
}
