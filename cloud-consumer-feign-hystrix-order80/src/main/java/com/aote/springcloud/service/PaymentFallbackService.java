package com.aote.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author aote
 * @Date 2020-05-31 14:33
 * @Version 1.0
 * @Description TODO
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK,YNY";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut,YNY";
    }
}
