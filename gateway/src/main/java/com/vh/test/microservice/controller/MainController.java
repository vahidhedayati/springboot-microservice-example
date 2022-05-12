package com.vh.test.microservice.controller;

import com.vh.test.microservice.dto.SearchBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/")
public class MainController {


    @Autowired
    private RestTemplate restTemplate;


    private HttpEntity<?> generateHttpEntity(Integer max, String text) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        SearchBean bean = new SearchBean();
        bean.setText(text);
        bean.setEntries(max);
        HttpEntity<SearchBean> httpEntity = new HttpEntity<>(bean, headers);
        return httpEntity;
    }

    /**
     * The 3 methods below cover all the different calls to all back end available methods:
     *
     * methodNames can be:
     *
     * arrayList
     * linkList
     * stringArray
     * arrayBlockingList
     * treeSet
     * stack
     * hashSet
     * hashMap
     * treeHashMap
     * concurrentHashMap
     *
     */



    @PostMapping("/{methodName}")
    public ResponseEntity<Flux<Map<String, Object>>>  list(@PathVariable String methodName, @RequestBody SearchBean content){
        Map<String,Object> response = restTemplate.postForObject("http://ARRAY-LIST/"+methodName+"/",generateHttpEntity(content.getEntries(),content.getText()), Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/{methodName}/{id}")
    public ResponseEntity<Flux<Map<String, Object>>>  findListByIndex(@PathVariable String methodName, @PathVariable Integer id){
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/"+methodName+"/"+id, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }


    @DeleteMapping("/{methodName}/{id}")
    public ResponseEntity<Flux<Map>> removeFromListByIndex(@PathVariable String methodName, @PathVariable Integer id) {
        ResponseEntity<Map> response =  restTemplate.exchange("http://ARRAY-LIST/arrayList/"+methodName+"/"+id, HttpMethod.DELETE,null, Map.class);
        return new ResponseEntity(Flux.just(response), response.getStatusCode());
    }

    /**
     * All of below methods covered by the 3 above methods which parse methodName (only difference between them all)
     *


    @PostMapping("/arrayList")
    public ResponseEntity<Flux<Map<String, Object>>>  arrayList(@RequestBody SearchBean content){
        Map<String,Object> response = restTemplate.postForObject("http://ARRAY-LIST/arrayList/",generateHttpEntity(content.getEntries(),content.getText()), Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/arrayList/{id}")
    public ResponseEntity<Flux<Map<String, Object>>>  findArrayListByIndex(@PathVariable Integer id){
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/arrayList/"+id, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }


    @DeleteMapping("/arrayList/{id}")
    public ResponseEntity<Flux<Map>> removeFromArrayListByIndex(@PathVariable Integer id) {
        ResponseEntity<Map> response =  restTemplate.exchange("http://ARRAY-LIST/arrayList/"+id, HttpMethod.DELETE,null, Map.class);
        return new ResponseEntity(Flux.just(response), response.getStatusCode());
    }


    @PostMapping("/linkList")
    public ResponseEntity<Flux<Map<String, Object>>>  fillLinkListArrayList(@RequestBody SearchBean content){
        Map<String,Object> response = restTemplate.postForObject("http://ARRAY-LIST/linkList/",generateHttpEntity(content.getEntries(),content.getText()), Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/linkList/{id}")
    public ResponseEntity<Flux<Map<String, Object>>>  findLinkedListByIndex(@PathVariable Integer id){
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/linkList/"+id, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }


    @DeleteMapping("/linkList/{id}")
    public ResponseEntity<Flux<Map>> removeFromLinkedListByIndex(@PathVariable Integer id) {
        ResponseEntity<Map> response =  restTemplate.exchange("http://ARRAY-LIST/linkList/"+id, HttpMethod.DELETE,null, Map.class);
        return new ResponseEntity(Flux.just(response), response.getStatusCode());
    }



    @PostMapping("/stringArray")
    public ResponseEntity<Flux<Map<String, Object>>>  fillStringArrayList(@RequestBody SearchBean content){
        Map<String,Object> response = restTemplate.postForObject("http://ARRAY-LIST/stringArray/",generateHttpEntity(content.getEntries(),content.getText()), Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/stringArray/{id}")
    public ResponseEntity<Flux<Map<String, Object>>>  findStringArrayListByIndex(@PathVariable Integer id){
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/stringArray/"+id, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }


    @DeleteMapping("/stringArray/{id}")
    public ResponseEntity<Flux<Map>> removeFromStringArrayListByIndex(@PathVariable Integer id) {
        ResponseEntity<Map> response =  restTemplate.exchange("http://ARRAY-LIST/stringArray/"+id, HttpMethod.DELETE,null, Map.class);
        return new ResponseEntity(Flux.just(response), response.getStatusCode());
    }



    @PostMapping("/arrayBlockingList")
    public ResponseEntity<Flux<Map<String, Object>>>  findArrayBlockingListByIndex(@RequestBody SearchBean content){
        Map<String,Object> response = restTemplate.postForObject("http://ARRAY-LIST/arrayBlockingList/",generateHttpEntity(content.getEntries(),content.getText()), Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/arrayBlockingList/{id}")
    public ResponseEntity<Flux<Map<String, Object>>>  findArrayBlockingListByIndex(@PathVariable Integer id){
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/arrayBlockingList/"+id, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }


    @DeleteMapping("/arrayBlockingList/{id}")
    public ResponseEntity<Flux<Map>> removeFromArrayBlockingListByIndex(@PathVariable Integer id) {
        ResponseEntity<Map> response =  restTemplate.exchange("http://ARRAY-LIST/arrayBlockingList/"+id, HttpMethod.DELETE,null, Map.class);
        return new ResponseEntity(Flux.just(response), response.getStatusCode());
    }



    @PostMapping("/treeSet")
    public ResponseEntity<Flux<Map<String, Object>>>  fillTreeSet(@RequestBody SearchBean content){
        Map<String,Object> response = restTemplate.postForObject("http://ARRAY-LIST/treeSet/",generateHttpEntity(content.getEntries(),content.getText()), Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/treeSet/{id}")
    public ResponseEntity<Flux<Map<String, Object>>>  findTreeSetByIndex(@PathVariable Integer id){
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/treeSet/"+id, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }


    @DeleteMapping("/treeSet/{id}")
    public ResponseEntity<Flux<Map>> removeFromTreeSetByIndex(@PathVariable Integer id) {
        ResponseEntity<Map> response =  restTemplate.exchange("http://ARRAY-LIST/treeSet/"+id, HttpMethod.DELETE,null, Map.class);
        return new ResponseEntity(Flux.just(response), response.getStatusCode());
    }


    @PostMapping("/stack")
    public ResponseEntity<Flux<Map<String, Object>>>  fillStack(@RequestBody SearchBean content){
        Map<String,Object> response = restTemplate.postForObject("http://ARRAY-LIST/stack/",generateHttpEntity(content.getEntries(),content.getText()), Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    @GetMapping("/stack/{id}")
    public ResponseEntity<Flux<Map<String, Object>>>  findStackByIndex(@PathVariable Integer id){
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/stack/"+id, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }


    @DeleteMapping("/stack/{id}")
    public ResponseEntity<Flux<Map>> removeFromStackByIndex(@PathVariable Integer id) {
        ResponseEntity<Map> response =  restTemplate.exchange("http://ARRAY-LIST/stack/"+id, HttpMethod.DELETE,null, Map.class);
        return new ResponseEntity(Flux.just(response), response.getStatusCode());
    }

     .....


    */


}
