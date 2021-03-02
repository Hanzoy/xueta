package com.hanzoy.xueta.service;

import com.hanzoy.xueta.dto.CommonResult;

public interface RankingListService {
    CommonResult getEmerging(String token);
    CommonResult getGeneral(String token);
}
