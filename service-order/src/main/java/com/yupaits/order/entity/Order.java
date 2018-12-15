package com.yupaits.order.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author yupaits
 * @date 2018/12/15
 */
@Data
@Builder
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private BigDecimal amount;
    private LocalDateTime orderTime;
}
