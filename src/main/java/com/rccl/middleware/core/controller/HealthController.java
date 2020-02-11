package com.rccl.middleware.core.controller;

import com.rccl.middleware.commons.models.reqres.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/core")
public class HealthController {
    
    @GetMapping(value = "/health")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<ResponseBody<String>> health() {
        return Mono.just(ResponseBody.<String>builder().payload("Health is up!").build());
    }
    
}
