package com.aote.springcloud.service;

import com.aote.springcloud.entities.CommonResult;
import com.aote.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author aote
 * @Date 2020-05-29 00:08
 * @Version 1.0
 * @Description TODO
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();


}
