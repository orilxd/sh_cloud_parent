package com.itheima.sh.controller;

import com.itheima.sh.clients.UserFeignApi;
import com.itheima.sh.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class FeignController {
    @Autowired
    UserFeignApi userFeignApi;

    @GetMapping("{id}")
    @HystrixCommand(fallbackMethod = "queryByIdFallBack")
    public User queryById(@PathVariable("id") String id){
        return userFeignApi.findById(id);
    }

    public User queryByIdFallBack(String id){

        User user = new User();
        user.setName(id);
        user.setNickName("UserFeignApiFallBack");

        return user;
    }
}
