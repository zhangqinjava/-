package com.zq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class MyThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor()
    {
        return new ThreadPoolExecutor(20
                ,200
                ,10
                , TimeUnit.SECONDS
                ,new LinkedBlockingQueue(10000)
                , Executors.defaultThreadFactory()
                ,new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
