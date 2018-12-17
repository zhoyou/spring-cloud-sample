package com.yupaits.client.shop.controller;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yupaits
 * @date 2018/12/17
 */
@RestController
public class ShopController {

    private final OAuth2RestTemplate restTemplate;

    @Autowired
    public ShopController(OAuth2RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/shop/order/search")
    public Map searchOrder(@RequestParam(required = false) String shopId,
                           @RequestParam(required = false) String orderId) {
        if (StringUtils.isEmpty(orderId)) {
            return Maps.newHashMap();
        }
        if (StringUtils.isEmpty(shopId)) {
            return restTemplate.getForObject("http://localhost:20000/shop/order/{orderId}", Map.class, orderId);
        } else {
            return restTemplate.getForObject("http://localhost:20000/shop/{shopId}/order/{orderId}", Map.class, shopId, orderId);
        }
    }
}
