package com.yupaits.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yupaits
 * @date 2018/12/15
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceShopApplication.class, args);
    }
}
