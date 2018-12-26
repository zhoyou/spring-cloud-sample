package com.yupaits.shop.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yupaits
 * @date 2018/12/26
 */
@FeignClient(name = "order-service")
public interface OrderRemoteService {

    @GetMapping("/{orderId}")
    ResponseEntity getOrderById(@PathVariable String orderId);
}
