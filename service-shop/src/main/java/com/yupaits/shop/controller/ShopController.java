package com.yupaits.shop.controller;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author yupaits
 * @date 2018/12/15
 */
@RestController
public class ShopController {

    private final RestTemplate restTemplate;

    @Autowired
    public ShopController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{shopId}/{orderId}")
    public ResponseEntity getShopOrder(@PathVariable String shopId, @PathVariable String orderId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put("shopId", shopId);
        result.put("order", restTemplate.getForObject("http://service-order/{orderId}", Map.class, orderId));
        return ResponseEntity.ok(result);
    }

}
