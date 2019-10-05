package com.barnnet.work.helper.util.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author barnnet
 * @date 2019/9/28
 */
@Component
public class RedisHandler {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    public void setString(String key,String value){
        stringRedisTemplate.boundValueOps(key).set(value);
    }

    public String getObject(String key) {
        String str = stringRedisTemplate.opsForValue().get(key);
        return str;
    }
}
