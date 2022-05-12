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
        System.out.println("-- "+response.getBody()+" -- "+response.toString());
        return new ResponseEntity(Flux.just(response), response.getStatusCode());
    }

}
