package com.itheima.sh.user.controller;

import com.itheima.sh.pojo.User;
import com.itheima.sh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //获取端口
    @Value("${server.port}")
    private Integer port;


    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") String username,
                          HttpServletRequest request) {



        System.out.println("PORT:  " + port);
        String name = request.getHeader("name");
        System.out.println(name);
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        int i = 1 / 0;

        return userService.queryById(username);
    }
}
