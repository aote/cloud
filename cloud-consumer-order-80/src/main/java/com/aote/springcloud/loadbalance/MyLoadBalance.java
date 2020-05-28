package com.aote.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author aote
 * @Date 2020-05-28 23:30
 * @Version 1.0
 * @Description 自己实现负载均衡轮询算法
 **/
@Component
public class MyLoadBalance implements LoadBalance {


    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    /**
     * 得到并增加
     * @return
     */
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            // 2147483647 == Integer.MAX_VALUE
            next = current >= 2147483647 ? 0 : current+1;
            // 如果 this.atomicInteger.compareAndSet(current,next) 不成立，一直自旋
        } while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第*****next:"+next);
        return next;
    }

}
