package com.itheima.sh.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
//@CrossOrigin(origins = "*") //允许源地址,解决前后端跨域问题(默认就是*,允许所有前端地址访问)
public class AddressController {

    @GetMapping("me")
    public String myAddress() {
        return "上海市浦东新区航头镇航头路18号传智播客";
    }
}
