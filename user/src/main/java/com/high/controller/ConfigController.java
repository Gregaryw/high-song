package com.high.controller;

import com.high.config.DatasourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Autowired
     private DatasourceConfig datasourceConfig;
    /**
     * http://localhost:8080/config/get
     */
    @RequestMapping("/get")
    public String get() {
        return datasourceConfig.getUrl();
    }
}