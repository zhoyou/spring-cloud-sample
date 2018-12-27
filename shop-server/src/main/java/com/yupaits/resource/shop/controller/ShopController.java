package com.yupaits.resource.shop.controller;

import com.yupaits.resource.shop.service.OrderRemoteService;
import com.yupaits.resource.shop.service.ShopRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yupaits
 * @date 2018/12/17
 */
@RestController
public class ShopController {

    private final ShopRemoteService shopService;
    private final OrderRemoteService orderService;

    @Autowired
    public ShopController(ShopRemoteService shopService, OrderRemoteService orderService) {
        this.shopService = shopService;
        this.orderService = orderService;
    }

    @GetMapping("/{shopId}/order/{orderId}")
    public ResponseEntity getShopOrder(@PathVariable String shopId, @PathVariable String orderId) {
        return ResponseEntity.ok(shopService.getShopOrder(shopId, orderId));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity getOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}
