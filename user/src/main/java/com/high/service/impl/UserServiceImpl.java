package com.high.service.impl;

import com.high.entity.User;
import com.high.mapper.UserMapper;
import com.high.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * User的服务接口的实现类
 * 
 * @author 
 *
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loadUserByUsername(String username) {
        return userMapper.loadUserByUsername(username);
    }
}