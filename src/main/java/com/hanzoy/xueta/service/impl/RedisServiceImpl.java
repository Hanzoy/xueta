package com.hanzoy.xueta.service.impl;

import com.hanzoy.xueta.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void setKey(String key, String value) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key, value, 300, TimeUnit.SECONDS);//5分钟过期
    }

    @Override
    public String getValue(String key) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void setDelayed(String key, int time) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key+"delayed", "delayed", time, TimeUnit.SECONDS);
    }

    @Override
    public boolean isDelayed(String key) {
        return Objects.equals(redisTemplate.opsForValue().get(key+"delayed"), "delayed");
    }
}
