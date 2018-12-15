package com.yupaits.order.controller;

import com.yupaits.order.entity.Order;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author yupaits
 * @date 2018/12/15
 */
@RestController
public class OrderController {

    @GetMapping("/{orderId}")
    public ResponseEntity getOrderById(@PathVariable String orderId) {
        return ResponseEntity.ok(Order.builder().id(orderId)
                .amount(BigDecimal.valueOf(Long.parseLong(RandomStringUtils.randomNumeric(3))))
                .orderTime(LocalDateTime.now()).build());
    }
}
