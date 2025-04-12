package com.polarbookshop.edgeservice.web;

import com.polarbookshop.edgeservice.config.PolarProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class WebEndpoints {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(PolarProperties polarProperties) {
        return RouterFunctions.route()
                .GET("/hello", request ->
                        ServerResponse.ok().body(Mono.just(polarProperties.getGreeting()), String.class))
                .GET("/catalog-fallback", request -> {
                    System.out.println(request);
                    return ServerResponse.ok().body(Mono.just("[]"), String.class);
                })
                .POST("/catalog-fallback",
                        request -> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build())
                .build();
    }
}
