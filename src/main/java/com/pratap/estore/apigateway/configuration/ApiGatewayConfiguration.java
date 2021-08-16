package com.pratap.estore.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(predicateSpec -> predicateSpec.path("/coupon-service/**")
                        .uri("lb://coupon-service"))
                .route(predicateSpec -> predicateSpec.path("/item-service/**")
                        .uri("lb://item-service"))
                .build();
    }
}
