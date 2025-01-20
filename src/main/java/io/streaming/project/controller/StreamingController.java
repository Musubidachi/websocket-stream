package io.streaming.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.streaming.project.service.DataRetrievalService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api/streaming")
@AllArgsConstructor
public class StreamingController {
	
	private final DataRetrievalService dataRetrievalService;
	
	@GetMapping("/data")
    public Mono<String> fetchData() {
        // Handle REST API request and return data as a Mono
        return Mono.fromCallable(() -> dataRetrievalService.fetchGetData());
    }

	@GetMapping("/stream-data/parallel-data")
    public Flux<String> fetchParallelData() {
        // Make three parallel calls to fetchGetData
        Flux<String> call1 = Mono.fromSupplier(() -> dataRetrievalService.fetchGetData())
                .subscribeOn(Schedulers.boundedElastic())
                .flux();
        Flux<String> call2 = Mono.fromSupplier(() -> dataRetrievalService.fetchGetData())
                .subscribeOn(Schedulers.boundedElastic())
                .flux();
        Flux<String> call3 = Mono.fromSupplier(() -> dataRetrievalService.fetchGetData())
                .subscribeOn(Schedulers.boundedElastic())
                .flux();

        // Merge the results into a single Flux
        return Flux.merge(call1, call2, call3);
    }
}