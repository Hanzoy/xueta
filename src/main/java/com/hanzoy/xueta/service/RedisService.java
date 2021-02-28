package com.hanzoy.xueta.service;

public interface RedisService {
    /**
     * 设置key-value
     * @param key
     * @param value
     */
    void setKey(String key, String value);

    /**
     * 获取key
     * @param key
     * @return
     */
    String getValue(String key);

    /**
     * 删除key
     * @param key
     */
    void delete(String key);

    void setDelayed(String key, int time);

    boolean isDelayed(String key);
}
