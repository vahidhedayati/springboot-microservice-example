package com.vh.test.microservice.controller;

import com.vh.test.microservice.dto.SearchBean;
import com.vh.test.microservice.util.InternalStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {


    private final InternalStorage internalStorage;


    public MainController(InternalStorage internalStorage) {
        this.internalStorage = internalStorage;
    }

    @PostMapping("/arrayList")
    ResponseEntity<?> fillArrayList(@RequestBody SearchBean content) {
        return ResponseEntity.ok(internalStorage.fillArrayList(content.getEntries(),content.getText()));
    }

    @GetMapping("/arrayList/{id}")
    ResponseEntity<?> findArrayListByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.findArrayListByIndex(id));
    }

    @DeleteMapping("/arrayList/{id}")
    ResponseEntity<?> removeFromArrayListByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.removeFromArrayListByIndex(id));
    }


    @PostMapping("/linkList")
    ResponseEntity<?> fillLinkListArrayList(@RequestBody SearchBean content) {
        return ResponseEntity.ok(internalStorage.fillLinkListArrayList(content.getEntries(),content.getText()));
    }

    @GetMapping("/linkList/{id}")
    ResponseEntity<?> findLinkedListByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.findLinkedListByIndex(id));
    }

    @DeleteMapping("/linkList/{id}")
    ResponseEntity<?> removeFromLinkedListByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.removeFromLinkedListByIndex(id));
    }



    @PostMapping("/stringArray")
    ResponseEntity<?> fillStringArrayList(@RequestBody SearchBean content) {
        return ResponseEntity.ok(internalStorage.fillStringArrayList(content.getEntries(),content.getText()));
    }

    @GetMapping("/stringArray/{id}")
    ResponseEntity<?> findStringArrayListByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.findStringArrayListByIndex(id));
    }

    @DeleteMapping("/stringArray/{id}")
    ResponseEntity<?> removeFromStringArrayListByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.removeFromStringArrayListByIndex(id));
    }


    @PostMapping("/arrayBlockingList")
    ResponseEntity<?> fillArrayBlockingList(@RequestBody SearchBean content) {
        return ResponseEntity.ok(internalStorage.fillArrayBlockingList(content.getEntries(),content.getText()));
    }

    @GetMapping("/arrayBlockingList/{id}")
    ResponseEntity<?> findArrayBlockingListByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.findArrayBlockingListByIndex(id));
    }

    @DeleteMapping("/arrayBlockingList/{id}")
    ResponseEntity<?> removeFromArrayBlockingListByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.removeFromArrayBlockingListByIndex(id));
    }

    @PostMapping("/treeSet")
    ResponseEntity<?> fillTreeSet(@RequestBody SearchBean content) {
        return ResponseEntity.ok(internalStorage.fillTreeSet(content.getEntries(),content.getText()));
    }

    @GetMapping("/treeSet/{id}")
    ResponseEntity<?> findTreeSetByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.findTreeSetByIndex(id));
    }

    @DeleteMapping("/treeSet/{id}")
    ResponseEntity<?> removeFromTreeSetByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.removeFromTreeSetByIndex(id));
    }


    @PostMapping("/stack")
    ResponseEntity<?> fillStack(@RequestBody SearchBean content) {
        return ResponseEntity.ok(internalStorage.fillStack(content.getEntries(),content.getText()));
    }

    @GetMapping("/stack/{id}")
    ResponseEntity<?> findStackByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.findStackByIndex(id));
    }

    @DeleteMapping("/stack/{id}")
    ResponseEntity<?> removeFromStackByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.removeFromStackByIndex(id));
    }


    @PostMapping("/hashSet")
    ResponseEntity<?> fillHashSet(@RequestBody SearchBean content) {
        return ResponseEntity.ok(internalStorage.fillHashSet(content.getEntries(),content.getText()));
    }

    @GetMapping("/hashSet/{id}")
    ResponseEntity<?> findHashSetByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.findHashSetByIndex(id));
    }

    @DeleteMapping("/hashSet/{id}")
    ResponseEntity<?> removeFromHashSetByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.removeFromHashSetByIndex(id));
    }


    @PostMapping("/hashMap")
    ResponseEntity<?> fillHashMap(@RequestBody SearchBean content) {
        return ResponseEntity.ok(internalStorage.fillHashMap(content.getEntries(),content.getText()));
    }

    @GetMapping("/hashMap/{id}")
    ResponseEntity<?> findHashMapByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.findHashMapByIndex(id));
    }

    @DeleteMapping("/hashMap/{id}")
    ResponseEntity<?> removeFromHashMapByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.removeFromHashMapByIndex(id));
    }


    @PostMapping("/treeHashMap")
    ResponseEntity<?> fillTreeHashMap(@RequestBody SearchBean content) {
        return ResponseEntity.ok(internalStorage.fillTreeHashMap(content.getEntries(),content.getText()));
    }

    @GetMapping("/treeHashMap/{id}")
    ResponseEntity<?> findTreeHashMapByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.findTreeHashMapByIndex(id));
    }

    @DeleteMapping("/treeHashMap/{id}")
    ResponseEntity<?> removeFromTreeHashMapByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.removeFromTreeHashMapByIndex(id));
    }


    @PostMapping("/concurrentHashMap")
    ResponseEntity<?> fillConcurrentHashMap(@RequestBody SearchBean content) {
        return ResponseEntity.ok(internalStorage.fillConcurrentHashMap(content.getEntries(),content.getText()));
    }

    @GetMapping("/concurrentHashMap/{id}")
    ResponseEntity<?> findConcurrentHashMapByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.findConcurrentHashMapByIndex(id));
    }

    @DeleteMapping("/concurrentHashMap/{id}")
    ResponseEntity<?> removeFromConcurrentHashMapByIndex(@PathVariable Integer id) {
        return ResponseEntity.ok(internalStorage.removeFromConcurrentHashMapByIndex(id));
    }

}
