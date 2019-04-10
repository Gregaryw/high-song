package com.high;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 容器启动类入口
 * @Author: HarlanW
 * @Date: 2019/3/21
 * @Version: 1.0
 */
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.high.mapper.**")
public class UserApplication {
    public static void main(String[] args) {
        log.info("容器类{}启动",UserApplication.class);
        SpringApplication.run(UserApplication.class,args);
    }

    @RestController
    class EchoController {
        @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery " + string;
        }
    }
}
