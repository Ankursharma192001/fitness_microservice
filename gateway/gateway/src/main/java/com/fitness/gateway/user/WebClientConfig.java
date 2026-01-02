package com.fitness.gateway.user;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    // name instead of hardCoded url -- by default - round-robin load balancing
    @Bean
    @LoadBalanced // needed to call userService via
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    // creating a webClient instance which is pointing to user services
    @Bean
    public WebClient userServiceWebClient(WebClient.Builder webClientBuilder){
        return webClientBuilder.
                baseUrl("http://USER-SERVICE").build();
    }

}
