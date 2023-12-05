package com.ms.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CustomFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Pre Processing Logic Goes here" + exchange.getRequest());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            System.out.println("Post Processing Logic Goes here" + exchange.getResponse());
        }));
    }
}
