package com.high;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: HarlanW
 * @Date: 2019/4/9 0009
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        new SpringApplication().run(ProductApplication.class,args);
    }
}
