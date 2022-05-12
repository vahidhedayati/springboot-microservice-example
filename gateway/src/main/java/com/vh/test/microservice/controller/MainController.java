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


    /**
     * Below are 3 REST calls using POST / GET / DELETE methods for the ip:port/{methodName} followed by
     * what ever the function requires as description below
     *
     */


    /**
     * POST as per above method names to i.e.
     * http://localhost:8085/arrayList/
     * POST BODY: { "elements" : "1000", "text": "what array elements text should be"  }
     *
     * http://localhost:8085/arrayBlockingList/
     * POST BODY:  { "elements" : "1000", "text": "what array elements text should be"  }
     *
     * The body is searchBean object as json
     *
     *
     * Using searchBean content:
     * @param methodName
     * @param content
     * @return
     */
    @PostMapping("/{methodName}")
    public ResponseEntity<Flux<Map<String, Object>>>  list(@PathVariable String methodName, @RequestBody SearchBean content){
        Map<String,Object> response = restTemplate.postForObject("http://ARRAY-LIST/"+methodName+"/",generateHttpEntity(content.getEntries(),content.getText()), Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }

    /**
     * GET as per above method names to i.e.
     * (only if you have first used above to fill the contents of the given method)
     * http://localhost:8085/arrayList/1
     *
     *  http://localhost:8085/concurrentHashMap/1
     * @param methodName
     * @param id
     * @return
     */
    @GetMapping("/{methodName}/{id}")
    public ResponseEntity<Flux<Map<String, Object>>>  findListByIndex(@PathVariable String methodName, @PathVariable Integer id){
        Map<String,Object> response = restTemplate.getForObject("http://ARRAY-LIST/"+methodName+"/"+id, Map.class);
        return new ResponseEntity<Flux<Map<String, Object>>>(Flux.just(response), HttpStatus.OK);
    }


    /**
     *  DELETE as per above method names to i.e.
     *  (only if you have first used above to fill the contents of the given method)
     *  http://localhost:8085/arrayList/1
     *
     *  http://localhost:8085/concurrentHashMap/1
     *
     * @param methodName
     * @param id
     * @return
     */
    @DeleteMapping("/{methodName}/{id}")
    public ResponseEntity<Flux<Map>> removeFromListByIndex(@PathVariable String methodName, @PathVariable Integer id) {
        ResponseEntity<Map> response =  restTemplate.exchange("http://ARRAY-LIST/arrayList/"+methodName+"/"+id, HttpMethod.DELETE,null, Map.class);
        return new ResponseEntity(Flux.just(response), response.getStatusCode());
    }

}
