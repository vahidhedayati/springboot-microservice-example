package com.vh.test.microservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
public class MainController {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${gateway.url:http://localhost:8085}")
    String serviceUrl;



    @GetMapping("/arrayList")
    @CircuitBreaker(name="arrayService", fallbackMethod = "arrayListFallback")
    @Retry(name="arrayRetry" )
    public ResponseEntity<Flux<Map<String, Object>>>  arrayList(@RequestParam(defaultValue = "1000000") Integer max){
        System.out.println("arrayList");
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/arrayList/?max="+max, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    public ResponseEntity<String> arrayListFallback(Exception e){
        return new ResponseEntity<String>("arrayList  service is down", HttpStatus.OK);

    }

    @GetMapping("/stringArrayList")
    public ResponseEntity<Flux<Map<String, Object>>>   stringArrayList(@RequestParam(defaultValue = "1000000") Integer max){
        System.out.println("stringArrayList");
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/stringArrayList/?max="+max, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }


    @GetMapping("/linkListArray")
    public ResponseEntity<Flux<Map<String, Object>>> linkListArray(@RequestParam(defaultValue = "1000000") Integer max){
        System.out.println("linkListArray");
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/linkListArray/?max="+max, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/hashSetList")
    public ResponseEntity<Flux<Map<String, Object>>> hashSetList(@RequestParam(defaultValue = "1000000") Integer max){
        System.out.println("hashSetList");
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/hashSetList/?max="+max, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/treeSetList")
    public ResponseEntity<Flux<Map<String, Object>>> treeSetList(@RequestParam(defaultValue = "1000000") Integer max){
        System.out.println("treeSetList");
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/treeSetList/?max="+max, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/hashMapList")
    public ResponseEntity<Flux<Map<String, Object>>> hashMapList(@RequestParam(defaultValue = "1000000") Integer max){
        System.out.println("hashMapList");
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/hashMapList/?max="+max, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/treeMapList")
    public ResponseEntity<Flux<Map<String, Object>>> treeMapList(@RequestParam(defaultValue = "1000000") Integer max){
        System.out.println("treeMapList");
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/treeMapList/?max="+max, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }


    @GetMapping("/stackList")
    public ResponseEntity<Flux<Map<String, Object>>> stackList(@RequestParam(defaultValue = "1000000") Integer max){
        System.out.println("stackList");
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/stackList/?max="+max, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }


    @GetMapping("/linkQueueList")
    public ResponseEntity<Flux<Map<String, Object>>> linkQueueList(@RequestParam(defaultValue = "1000000") Integer max){
        System.out.println("linkQueueList");
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/linkQueueList/?max="+max, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/blockingQueueList")
    public ResponseEntity<Flux<Map<String, Object>>> blockingQueueList(@RequestParam(defaultValue = "1000000") Integer max){
        System.out.println("blockingQueueList");
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/blockingQueueList/?max="+max, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }
}
