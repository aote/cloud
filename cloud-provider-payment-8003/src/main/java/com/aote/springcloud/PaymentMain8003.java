package com.aote.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author aote
 * @Date 2020-05-26 21:26
 * @Version 1.0
 * @Description 使用zookeeper注册的provider
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8003 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8003.class,args);
    }

}
