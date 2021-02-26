package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.mapper.AphorismExtendsMapper;
import com.hanzoy.xueta.service.AphorismService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

@Service
public class AphorismServiceImpl implements AphorismService {
    @Resource
    AphorismExtendsMapper customAphorismMapper;

    @Override
    public CommonResult getAphorism() {
        HashMap<String, String> data = new HashMap<>();
        data.put("aphorism", customAphorismMapper.getAphorism());
        return CommonResult.success(data);
    }
}
