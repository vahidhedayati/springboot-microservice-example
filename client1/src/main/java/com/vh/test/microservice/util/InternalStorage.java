package com.vh.test.microservice.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InternalStorage {

    // private static  Integer MAX_ITERATION=1;
    // public static void setMaxIteration(Integer maxIteration) { MAX_ITERATION = maxIteration }

    private List<String> ARRAY_LIST = new ArrayList<>();
    private List<String> LINKED_ARRAY_LIST = new LinkedList<>();

    private String[] STRING_ARRAY;   // =  new String[MAX_ITERATION];
    private Queue<String> ARRAY_BLOCKING_LIST;  //= new ArrayBlockingQueue<String>(MAX_ITERATION);


    private Set<String> TREE_SET =  new TreeSet<>();
    private Stack<String> STACK = new Stack<>();
    private HashSet<String> HASHSET = new HashSet<>();


    private Map<Integer, String> HASHMAP = new HashMap<>();
    private Map<Integer, String> TREE_HASHMAP = new TreeMap<>();
    private Map<Integer, String> CONCURRENT_HASHMAP = new ConcurrentHashMap<>();




    public Map<String, Object> fillArrayList(int sizeOfArray, String content) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        for (int i=0; i < sizeOfArray; i++) {
            ARRAY_LIST.add(content+" "+i);
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "fillArrayList");
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> findArrayListByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        String item = ARRAY_LIST.get(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "findArrayListByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("valueOfIndex", item);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> removeFromArrayListByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        ARRAY_LIST.remove(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "removeFromArrayListByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }

    public Map<String, Object> fillLinkListArrayList(int sizeOfArray, String content) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        for (int i=0; i < sizeOfArray; i++) {
            LINKED_ARRAY_LIST.add(content+" "+i);
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "fillLinkListArrayList");
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> findLinkedListByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        String item = LINKED_ARRAY_LIST.get(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "findLinkedListByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("valueOfIndex", item);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> removeFromLinkedListByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        LINKED_ARRAY_LIST.remove(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "removeFromLinkedListByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }


    public Map<String, Object> fillStringArrayList(int sizeOfArray, String content) {
        STRING_ARRAY =new String[sizeOfArray];
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        for (int i=0; i < sizeOfArray; i++) {
            STRING_ARRAY[i]=content+" "+i;
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "fillStringArrayList");
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> findStringArrayListByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        String item=STRING_ARRAY[index];
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "findStringArrayListByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("valueOfIndex", item);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> removeFromStringArrayListByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        String[] aCopy = new String[STRING_ARRAY.length - 1];
        for (int i = 0, k = 0; i < STRING_ARRAY.length; i++) {
            if (i == index) {
                continue;
            }
            aCopy[k++] = STRING_ARRAY[i];
        }
        STRING_ARRAY=aCopy;
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "removeFromLinkedListByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }


    public Map<String, Object> fillArrayBlockingList(int sizeOfArray, String content) {
        ARRAY_BLOCKING_LIST = new ArrayBlockingQueue<String>(sizeOfArray);
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        for (int i=0; i < sizeOfArray; i++) {
            ARRAY_BLOCKING_LIST.add(content+" "+i);
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "fillArrayBlockingList");
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> findArrayBlockingListByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        Iterator<String> iterator = ARRAY_BLOCKING_LIST.iterator();
        int i = 0;
        String item="";
        while(iterator.hasNext()) {
            String current = iterator.next();
            if(index==i) {
                item = current;
                // iterator.remove();
                break;
            }
            i++;
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "findArrayBlockingListByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("valueOfIndex", item);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> removeFromArrayBlockingListByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        Iterator<String> iterator = ARRAY_BLOCKING_LIST.iterator();
        int i = 0;
        String item="";
        while(iterator.hasNext()) {
            String current = iterator.next();
            if(index==i) {
                iterator.remove();
                break;
            }
            i++;
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "removeArrayBlockingListByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }



    public Map<String, Object> fillTreeSet(int sizeOfArray, String content) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        for (int i=0; i < sizeOfArray; i++) {
            TREE_SET.add(content+" "+i);
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "fillTreeSet");
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> findTreeSetByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        List<String> stringsList = new ArrayList<>(TREE_SET);
        String item= stringsList.get(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "findTreeSetByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("valueOfIndex", item);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> removeFromTreeSetByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        List<String> stringsList = new ArrayList<>(TREE_SET);
        stringsList.remove(index);
        TREE_SET = new HashSet<>(stringsList);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "removeFromTreeSetByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }


    public Map<String, Object> fillStack(int sizeOfArray, String content) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        for (int i=0; i < sizeOfArray; i++) {
            STACK.add(content+" "+i);
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "fillStack");
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> findStackByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        String item= STACK.get(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "findStackByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("valueOfIndex", item);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> removeFromStackByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        STACK.remove(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "removeFromStackByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }

    public Map<String, Object> fillHashSet(int sizeOfArray, String content) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        for (int i=0; i < sizeOfArray; i++) {
            HASHSET.add(content+" "+i);
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "fillHashSet");
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> findHashSetByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        List<String> stringsList = new ArrayList<>(HASHSET);
        String item= stringsList.get(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "findHashSetByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("valueOfIndex", item);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> removeFromHashSetByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        List<String> stringsList = new ArrayList<>(HASHSET);
        stringsList.remove(index);
        HASHSET = new HashSet<>(stringsList);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "removeFromHashSetByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }


    public Map<String, Object> fillHashMap(int sizeOfArray, String content) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        for (int i=0; i < sizeOfArray; i++) {
            HASHMAP.put(i, content+" "+i);
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "fillHashMap");
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> findHashMapByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        String item= HASHMAP.get(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "findHashMapByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("valueOfIndex", item);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> removeFromHashMapByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        HASHMAP.remove(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "removeFromHashMapByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }


    public Map<String, Object> fillTreeHashMap(int sizeOfArray, String content) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        for (int i=0; i < sizeOfArray; i++) {
            TREE_HASHMAP.put(i, content+" "+i);
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "fillTreeHashMap");
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> findTreeHashMapByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        String item= TREE_HASHMAP.get(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "findTreeHashMapByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("valueOfIndex", item);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> removeFromTreeHashMapByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        TREE_HASHMAP.remove(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "removeFromTreeHashMapByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }

    public Map<String, Object> fillConcurrentHashMap(int sizeOfArray, String content) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        for (int i=0; i < sizeOfArray; i++) {
            CONCURRENT_HASHMAP.put(i, content+" "+i);
        }
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "fillConcurrentHashMap");
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> findConcurrentHashMapByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        String item= CONCURRENT_HASHMAP.get(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "findConcurrentHashMapByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("valueOfIndex", item);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }
    public Map<String, Object> removeFromConcurrentHashMapByIndex(int index) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        CONCURRENT_HASHMAP.remove(index);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("method", "removeFromTreeHashMapByIndex");
        arrayResult.put("indexId:", index);
        arrayResult.put("timeTaken", estimated);
        return arrayResult;
    }

    public BigDecimal estimateTime(long dt) {
        return new BigDecimal(String.valueOf(dt/1000000.)).stripTrailingZeros();
    }
}
