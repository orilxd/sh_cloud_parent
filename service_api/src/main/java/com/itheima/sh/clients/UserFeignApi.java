package com.itheima.sh.clients;

import com.itheima.sh.clients.fallback.UserFeignApiFallBack;
import com.itheima.sh.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",fallback = UserFeignApiFallBack.class)
public interface UserFeignApi {
    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") String name);
}
