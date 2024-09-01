package com.zq.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
@Configuration
@Slf4j
public class MallFeginConfig {
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new RequestInterceptor() {
            public void apply(RequestTemplate requestTemplate) {
                log.info("RequestInterceptor："+Thread.currentThread().getName());
                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = requestAttributes.getRequest();
                String cookie = request.getHeader("Cookie");
                requestTemplate.header("Cookie",cookie);
            }
        };
    }
}
