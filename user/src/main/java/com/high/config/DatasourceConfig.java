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
@ConfigurationProperties(prefix = "spring.datasource")
public class DatasourceConfig {
    private String url;
    private String username;
    private String password;
    private String driverClassName;

}
