package com.aote.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: Weicf
 * @date: 2020-05-28 0:14
 * @description:
 */
@RestController
@Slf4j
public class OrderConsulController {

    private static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String payment(){
        String res = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return res;
    }

}
