package com.aote.springcloud.service;

import com.aote.springcloud.entities.Payment;

/**
 * @Author aote
 * @Date 2020-05-26 21:50
 * @Version 1.0
 * @Description TODO
 **/
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
