package com.itheima.sh.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(-1) //越小越优先
public class LoginFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.得到 request 对象
        ServerHttpRequest request = exchange.getRequest();


        //2.从request获取请求参数 token
        String token = request.getQueryParams().getFirst("token");

        //3.判断access-token值是否为admin
        if (!"admin".equals(token)) {
            //拦截
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

            return exchange.getResponse().setComplete();
        }

        //放行
        return chain.filter(exchange);
    }
}
