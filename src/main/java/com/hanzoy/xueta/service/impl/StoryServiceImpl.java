package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.domain.Prop;
import com.hanzoy.xueta.domain.PropExample;
import com.hanzoy.xueta.dto.CommonResult;
import com.hanzoy.xueta.mapper.PropMapper;
import com.hanzoy.xueta.service.StoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Service
public class StoryServiceImpl implements StoryService {

    @Resource
    PropMapper propMapper;

    @Override
    public CommonResult getPropList() {
        PropExample propExample = new PropExample();
        propExample.createCriteria();
        List<Prop> props = propMapper.selectByExample(propExample);
        HashMap<String, Object> data = new HashMap<>();
        data.put("count", props.size());
        data.put("info", props);
        return CommonResult.success(data);
    }
}
