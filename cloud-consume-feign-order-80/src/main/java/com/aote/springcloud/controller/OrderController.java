package com.aote.springcloud.controller;

import com.aote.springcloud.entities.CommonResult;
import com.aote.springcloud.entities.Payment;
import com.aote.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author aote
 * @Date 2020-05-29 00:12
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        // openFeign默认等待1秒
        return paymentFeignService.paymentFeignTimeout();
    }

}
