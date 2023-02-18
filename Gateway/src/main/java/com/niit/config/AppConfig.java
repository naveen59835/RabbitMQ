/*
 * Author : Naveen Kumar
 * Date : 13-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/v1/**")
                        .uri("lb://user-auth-service"))
                .route(p->p
                        .path("/api/v2/**")
                        .uri("lb://user-product-service"))
                .route(p->p
                        .path("/api/v3/**")
                        .uri("lb://user-notification-service"))

                .build();
    }
}
