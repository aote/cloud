package com.aote.springcloud;

import com.aote.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author aote
 * @Date 2020-05-26 23:43
 * @Version 1.0
 * @Description TODO
 **/
@SpringBootApplication
@EnableEurekaClient
// 配置负载均衡的提供者，ribbon是在客户端做负载均衡
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }

}
