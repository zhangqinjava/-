package com.zq.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRedisConfig {
    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        // 配置连接的信息
        config.useSingleServer()
                .setAddress("redis://****:6379");
        RedissonClient redissonClient = Redisson.create(config);
        return  redissonClient;
    }
}
