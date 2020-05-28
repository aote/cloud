package com.aote.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author aote
 * @Date 2020-05-28 22:07
 * @Version 1.0
 * @Description ribbon负载均衡规则类，必须放在不能被springboot扫描的包下面
 **/
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

    // 自己实现一个负载均衡轮询算法


}
