package com.aote.springcloud.controller;

import com.aote.springcloud.entities.CommonResult;
import com.aote.springcloud.entities.Payment;
import com.aote.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author aote
 * @Date 2020-05-26 21:52
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if(result>0){
            return new CommonResult(200,"插入成功，serverPort="+serverPort,result);
        }else {
            return new CommonResult(400,"插入失败，serverPort="+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);
        System.out.println("1111222221");
        if(payment != null){
            return new CommonResult(200,"查询成功，serverPort="+serverPort,payment);
        }else {
            return new CommonResult(400,"没有对应记录，查询Id："+id,null);
        }
    }

    // 返回端口号
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
