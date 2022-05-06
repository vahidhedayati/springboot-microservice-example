package com.vh.test.microservice.controller;

import com.vh.test.microservice.util.CompareIteratorsAndMaps;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
public class LaunchController {

    @GetMapping("/arrayList")
    public Flux<Map<String, Object>> arrayList( @RequestParam(defaultValue = "1000000") Integer max) {
        CompareIteratorsAndMaps ctp = new CompareIteratorsAndMaps<String>();
        Map<String,Object> result =  ctp.getArrayList(max, "0");
        result.put("method", "arrayList");
        return Flux.just(result);
    }

    @GetMapping("/stringArrayList")
    public Flux<Map<String, Object>> stringArray( @RequestParam(defaultValue = "1000000") Integer max) {
        CompareIteratorsAndMaps ctp = new CompareIteratorsAndMaps<String>();
        Map<String,Object> result =  ctp.getStrArrList(max, "0");
        result.put("method", "stringArrayList");
        return Flux.just(result);
    }

    @GetMapping("/linkListArray")
    public Flux<Map<String, Object>> linkList( @RequestParam(defaultValue = "1000000") Integer max) {
        CompareIteratorsAndMaps ctp = new CompareIteratorsAndMaps<String>();
        Map<String,Object> result =  ctp.getLinkList(max, "0");
        result.put("method", "linkList");
        return Flux.just(result);
    }


    @GetMapping("/hashSetList")
    public Flux<Map<String, Object>> hashSetList( @RequestParam(defaultValue = "1000000") Integer max) {
        CompareIteratorsAndMaps ctp = new CompareIteratorsAndMaps<String>();
        Map<String,Object> result =  ctp.getHashSetList(max, "0");
        result.put("method", "hashSetList");
        return Flux.just(result);
    }

    @GetMapping("/treeSetList")
    public Flux<Map<String, Object>> treeSetList( @RequestParam(defaultValue = "1000000") Integer max) {
        CompareIteratorsAndMaps ctp = new CompareIteratorsAndMaps<String>();
        Map<String,Object> result =  ctp.getTreeSetList(max, "0");
        result.put("method", "treeSetList");
        return Flux.just(result);
    }

    @GetMapping("/hashMapList")
    public Flux<Map<String, Object>> hashMapList( @RequestParam(defaultValue = "1000000") Integer max) {
        CompareIteratorsAndMaps ctp = new CompareIteratorsAndMaps<String>();
        Map<String,Object> result =  ctp.getHashMapList(max, "0");
        result.put("method", "hashMapList");
        return Flux.just(result);
    }


    @GetMapping("/treeMapList")
    public Flux<Map<String, Object>> treeMapList( @RequestParam(defaultValue = "1000000") Integer max) {
        CompareIteratorsAndMaps ctp = new CompareIteratorsAndMaps<String>();
        Map<String,Object> result =  ctp.getTreeMapList(max, "0");
        result.put("method", "treeMapList");
        return Flux.just(result);
    }

    @GetMapping("/stackList")
    public Flux<Map<String, Object>> stackList(@RequestParam(defaultValue = "1000000") Integer max) {
        CompareIteratorsAndMaps ctp = new CompareIteratorsAndMaps<String>();
        Map<String,Object> result =  ctp.getStackList(max, "0");
        result.put("method", "stackList");
        return Flux.just(result);
    }


    @GetMapping("/linkQueueList")
    public Flux<Map<String, Object>> linkQueueList( @RequestParam(defaultValue = "1000000") Integer max) {
        CompareIteratorsAndMaps ctp = new CompareIteratorsAndMaps<String>();
        Map<String,Object> result =  ctp.getLinkQueueList(max, "0");
        result.put("method", "linkQueueList");
        return Flux.just(result);
    }

    @GetMapping("/blockingQueueList")
    public  Flux<Map<String, Object>> blockingQueueList( @RequestParam(defaultValue = "1000000") Integer max) {
        CompareIteratorsAndMaps ctp = new CompareIteratorsAndMaps<String>();
        Map<String,Object> result =  ctp.getBlockingQueueList(max, "0");
        result.put("method", "blockingQueueList");
        return Flux.just(result);
    }
}
