package com.yupaits.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author yupaits
 * @date 2018/12/15
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceShopApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
