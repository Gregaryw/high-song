package com.high.controller;

import com.high.entity.User;
import com.high.service.UserService;
import com.high.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: HarlanW
 * @Date: 2019/4/2 0002
 * @Version: 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public Result login(String username){
       // User user = userService.loadUserByUsername(username);

        User user = new User();
        user.setUsername(username);
       return Result.success("test");
    }
}
