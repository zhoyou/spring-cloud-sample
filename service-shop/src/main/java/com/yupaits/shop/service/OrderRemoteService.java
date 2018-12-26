package com.yupaits.shop.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @author yupaits
 * @date 2018/12/26
 */
@FeignClient(name = "service-order")
public interface OrderRemoteService {

    @GetMapping("/{orderId}")
    Map getOrderById(@PathVariable String orderId);
}
