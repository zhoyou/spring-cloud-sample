package com.yupaits.resource.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author yupaits
 * @date 2018/12/17
 */
@RestController
public class ShopController {

    private final RestTemplate restTemplate;

    @Autowired
    public ShopController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{shopId}/order/{orderId}")
    public ResponseEntity getShopOrder(@PathVariable String shopId, @PathVariable String orderId) {
        Map result = restTemplate.getForObject("http://service-shop/{shopId}/{orderId}", Map.class, shopId, orderId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity getOrder(@PathVariable String orderId) {
        Map result = restTemplate.getForObject("http://service-order/{orderId}", Map.class, orderId);
        return ResponseEntity.ok(result);
    }
}
