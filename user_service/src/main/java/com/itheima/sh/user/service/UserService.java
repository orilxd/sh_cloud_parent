package com.itheima.sh.user.service;

import com.itheima.sh.user.mapper.UserMapper;
import com.itheima.sh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(String username) {
        return userMapper.findById(username);
    }
}
