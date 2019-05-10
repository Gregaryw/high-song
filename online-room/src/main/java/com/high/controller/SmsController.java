package com.high.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: HarlanW
 * @Date: 2019/4/19 0019
 * @Version: 1.0
 */
@RestController
public class SmsController {

    @RequestMapping("/sms/result")
    public String result(){
        return "成功！";
    }
}
