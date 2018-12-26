package com.yupaits.shop.controller;

import com.google.common.collect.Maps;
import com.yupaits.shop.service.OrderRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yupaits
 * @date 2018/12/15
 */
@RestController
public class ShopController {

    private final OrderRemoteService orderService;

    @Autowired
    public ShopController(OrderRemoteService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{shopId}/{orderId}")
    public ResponseEntity getShopOrder(@PathVariable String shopId, @PathVariable String orderId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put("shopId", shopId);
        result.put("order", orderService.getOrderById(orderId));
        return ResponseEntity.ok(result);
    }

}
