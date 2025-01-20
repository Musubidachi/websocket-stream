package io.streaming.project.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import io.streaming.project.service.DataRetrievalService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Controller
@AllArgsConstructor
public class WebSocketController {
	
	private final DataRetrievalService dataRetrievalService;
	
    @MessageMapping("/ws-message")
    @SendTo("/topic/updates")
    public Mono<String> handleWebSocketMessage(String message) {
    	// Process WebSocket message and fetch data
        return Mono.fromSupplier(() -> {
            String fetchedData = dataRetrievalService.fetchGetData();
            return "Processed: " + message + ", Data: " + fetchedData;
        });
    }
}