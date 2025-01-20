package io.streaming.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import io.streaming.project.model.RandomUserResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DataRetrievalService {

    private final WebClient webClient;

    /**
     * Fetch data using the GET endpoint.
     */
    public String fetchGetData() {
        return webClient.get()
                .uri("/api/example/get-data") // Other service's GET endpoint
                .retrieve()
                .bodyToMono(String.class) // Convert response to String
                .block(); // Blocking for simplicity in this example
    }

    /**
     * Fetch data using the POST endpoint.
     */
    public String fetchPostData(String requestData) {
        return webClient.post()
                .uri("/api/example/post-data") // Other service's POST endpoint
                .bodyValue(requestData) // Set the request body
                .retrieve()
                .bodyToMono(String.class) // Convert response to String
                .block();
    }

    /**
     * Fetch data using the GraphQL query.
     */
    public RandomUserResponse fetchGraphQLData() {
        String query = "{ getRandomUserFromCamel { results { name { first last } } } }";

        return webClient.post()
                .uri("/graphql") // GraphQL endpoint
                .bodyValue("{\"query\":\"" + query + "\"}") // Set GraphQL query
                .retrieve()
                .bodyToMono(RandomUserResponse.class) // Convert response to RandomUserResponse
                .block();
    }
}

