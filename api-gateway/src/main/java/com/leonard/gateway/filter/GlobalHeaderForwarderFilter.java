package com.leonard.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalHeaderForwarderFilter implements GlobalFilter {
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    log.info("=== Start header forwarder filter ===");

    var headers = exchange.getRequest().getHeaders();
    log.info("Upcoming headers: [{}]", headers.toSingleValueMap());
    var modifiedHeaders = new HttpHeaders();
    modifiedHeaders.addAll(headers);
    modifiedHeaders.add("test_header", "Leonard test header");
    var request = exchange.getRequest().mutate()
        .headers(httpHeaders -> httpHeaders.addAll(modifiedHeaders))
        .build();

    log.info("forward request to service with headers: [{}]", modifiedHeaders.toSingleValueMap());
    return chain.filter(exchange.mutate().request(request).build());
  }
}
