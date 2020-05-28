package com.aote.springcloud.controller;

import com.aote.springcloud.entities.CommonResult;
import com.aote.springcloud.entities.Payment;
import com.aote.springcloud.loadbalance.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author aote
 * @Date 2020-05-26 23:48
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001/";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalance loadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    // getForObject相当于返回json，getForEntity返回responseEntity
    // 参考文档写restTemplate.getForEntity
    @GetMapping("consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentForEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity =
                restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        } else {
            return new CommonResult<>(400,"操作失败");
        }
    }

    // 返回端口号
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        // 重点！！！
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances==null && instances.size()<=0){
            return null;
        }
        ServiceInstance instance = loadBalance.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
