package com.itheima.sh.controller;

import com.itheima.sh.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
@DefaultProperties(defaultFallback="defaultCallback")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /*   @GetMapping("{id}")
       public Map queryById(@PathVariable("id") String id){
           String url = "http://localhost:8081/user/" + id;
           // 调用RestTemplate的getForObject方法，指定url地址和返回值类型
           Map user = restTemplate.getForObject(url, Map.class);
           return user;
       }
   */
    @Autowired
    DiscoveryClient discoveryClient;

  /*  @GetMapping("{id}")
    public Map queryById(@PathVariable("id") String id){

        List<ServiceInstance> instances = discoveryClient.getInstances("USER-SERVICE");
        ServiceInstance serviceInstance = instances.get(0);

        String host = serviceInstance.getHost();  // 获取主机地址
        int port = serviceInstance.getPort();     // 获取端口
        String url = serviceInstance.getUri().toString(); // 获取请求URL

        // String url = "http://localhost:8081/user/" + id;
        // 调用RestTemplate的getForObject方法，指定url地址和返回值类型
        Map user = restTemplate.getForObject(url+"/user/"+id, Map.class);
        return user;
    }*/

    @GetMapping("{id}")
//    @HystrixCommand(fallbackMethod = "queryByIdFallBack")
    @HystrixCommand
    public User queryById(@PathVariable("id") String id){
        if("itheima".equals(id)){
            throw new RuntimeException("太忙了");
        }
        User user = restTemplate.getForObject("http://user-service/user/"+id, User.class);
        return user;
    }

    public User queryByIdFallBack(String id) {
        User user = new User();
        user.setName("-1");

        return user;
    }

    public User defaultCallback(){
        User user = new User();
        user.setName("默认提示：您的网络拥堵");
        return user;
    }


}
