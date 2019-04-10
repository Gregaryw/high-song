package com.high.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: HarlanW
 * @Date: 2019/4/1 0001
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class HikariConfig {
    private String maximumPoolSize;
    private String minimumIdle;
}
