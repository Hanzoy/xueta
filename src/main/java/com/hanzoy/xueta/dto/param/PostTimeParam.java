package com.hanzoy.xueta.dto.param;

import lombok.Data;

import java.util.List;

@Data
public class PostTimeParam {
    private String token;
    private int time;
    private List<Groups> group;
    private String sign;
    private String label;

    @Data
    public static class Groups{
        private int id;
        private int number;
    }
}
