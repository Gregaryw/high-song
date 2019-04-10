package com.high.mapper;

import com.high.entity.User;

/**
 * User的Mapper接口
 * 
 * @author 
 *
 */
public interface UserMapper {

    /**
     * 根据用户名获取用户数据
     * @param username 用户名
     * @return 用户对象
     */
    User loadUserByUsername(String username);
}