package com.itheima.sh.ratelimit;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class IpKeyResolver implements KeyResolver {


    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        //IP
        return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
