package com.aote.springcloud.service.impl;

import com.aote.springcloud.dao.PaymentDao;
import com.aote.springcloud.entities.Payment;
import com.aote.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author aote
 * @Date 2020-05-26 21:51
 * @Version 1.0
 * @Description TODO
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
