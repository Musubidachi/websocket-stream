package io.streaming.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${service.url}")
    private String serviceUrl; // Injected from the environment or application.properties

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl(serviceUrl) // Set the base URL dynamically
                .build();
    }
}

