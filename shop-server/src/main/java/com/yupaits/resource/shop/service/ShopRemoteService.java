package com.yupaits.resource.shop.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @author yupaits
 * @date 2018/12/27
 */
@FeignClient(name = "service-shop")
public interface ShopRemoteService {

    @GetMapping("/{shopId}/{orderId}")
    Map getShopOrder(@PathVariable String shopId, @PathVariable String orderId);
}
