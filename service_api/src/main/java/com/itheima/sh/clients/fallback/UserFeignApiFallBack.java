package com.itheima.sh.clients.fallback;

import com.itheima.sh.clients.UserFeignApi;
import com.itheima.sh.pojo.User;
import org.springframework.stereotype.Component;

@Component //组件扫描
public class UserFeignApiFallBack implements UserFeignApi {
    @Override
    public User findById(String username) {
        User user = new User();
        user.setName(username);
        user.setNickName("暂停服务===UserFeignApiFallBack");

        return user;
    }
}
