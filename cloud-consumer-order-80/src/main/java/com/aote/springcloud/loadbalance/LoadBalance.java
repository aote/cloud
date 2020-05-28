package com.aote.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 *
 */
public interface LoadBalance {

    public ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
