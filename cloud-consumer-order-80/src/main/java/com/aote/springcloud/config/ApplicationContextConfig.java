package com.aote.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author aote
 * @Date 2020-05-26 23:49
 * @Version 1.0
 * @Description TODO
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // 负载均衡，只有加上注解才能查询到对应的提供者
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
