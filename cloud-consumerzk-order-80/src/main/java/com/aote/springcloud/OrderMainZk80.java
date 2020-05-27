package com.aote.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author aote
 * @Date 2020-05-26 23:43
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainZk80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainZk80.class,args);
    }

}
