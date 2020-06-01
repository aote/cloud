package com.aote.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author aote
 * @Date 2020-05-26 23:43
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@EnableFeignClients // 使用feign，激活并开启
@EnableHystrix
public class OrderFeignHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain80.class,args);
    }

}
