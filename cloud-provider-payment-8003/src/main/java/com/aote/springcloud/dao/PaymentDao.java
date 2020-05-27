package com.aote.springcloud.dao;

import com.aote.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author aote
 * @Date 2020-05-26 21:34
 * @Version 1.0
 * @Description TODO
 **/
@Mapper // 推荐使用Mapper注解
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
