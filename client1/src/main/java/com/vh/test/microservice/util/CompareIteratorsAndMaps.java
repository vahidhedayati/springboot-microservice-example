package com.vh.test.microservice.util;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;


public class CompareIteratorsAndMaps<T> {



    public Map<String, Object> getHashMapList(int maxIterator, T d) {
        return launch(new HashMap<>(),maxIterator,d);
    }

    public Map<String, Object> getTreeMapList(int maxIterator, T d) {
        return launch(new TreeMap<>(),maxIterator,d);
    }

    public Map<String, Object> getTreeSetList(int maxIterator, T d) {
        return launch(new TreeSet<>(),maxIterator,d);
    }

    public Map<String, Object> getHashSetList(int maxIterator, T d) {
        return launch(new HashSet<>(),maxIterator,d);
    }

    //LIFO
    public   Map<String, Object> getStackList(int maxIterator, T d) {
        return launch(new Stack<>() ,  maxIterator,  d);
    }

    //FIFO
    public   Map<String, Object> getBlockingQueueList(int maxIterator, T d) {
        return launch(new ArrayBlockingQueue<T>(maxIterator) ,  maxIterator,  d);
    }
    //FIFO
    public   Map<String, Object> getLinkQueueList(int maxIterator, T d) {
        return launch((Queue<T>) new LinkedList<>() ,  maxIterator,  d);
    }

    public   Map<String, Object> getLinkList(int maxIterator, T d) {
        return launch((List<T>) new LinkedList<>() ,  maxIterator,  d);
    }
    public   Map<String, Object> getStrArrList(int maxIterator, T d) {
        return launch(new String[maxIterator],  maxIterator, d);
    }

    public Map<String, Object> getArrayList(int maxIterator, T d) {
        return launch((List<T>) new ArrayList<>() ,  maxIterator,  d);
    }


    public  Map<String, Object> launch(List<T> result , int maxIterator, T d) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();

        arrayResult = addAllRecords(arrayResult, maxIterator, result, d);
        result = (List<T>) arrayResult.get("list");
        arrayResult = removeByIndex(result, arrayResult, maxIterator / 2);
        arrayResult = findByIndex(result, arrayResult, maxIterator / 2);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("zfinal_time", estimated);

        arrayResult.remove("list");
        return arrayResult;
    }

    public  Map<String, Object> launch(String[] result , int maxIterator, T d) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();

        arrayResult = addAllRecords(arrayResult, maxIterator, result, d);
        result = (String[]) arrayResult.get("list");
        arrayResult = removeByIndex(result, arrayResult, maxIterator / 2);
        arrayResult = findByIndex(result, arrayResult, maxIterator / 2);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("zfinal_time", estimated);

        arrayResult.remove("list");
        return arrayResult;
    }


    public Map<String, Object> launch(Map<Integer,T> result, int maxIterator, T d) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        arrayResult = addAllRecords(arrayResult, maxIterator, result, d);
        result = (Map<Integer,T>) arrayResult.get("list");
        arrayResult = removeByIndex(result, arrayResult, maxIterator / 2);
        arrayResult = findByIndex(result, arrayResult, maxIterator / 2);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("zfinal_time", estimated);

        arrayResult.remove("list");
        return arrayResult;
    }

    public Map<String, Object> launch(Set<T> result, int maxIterator, T d) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        arrayResult = addAllRecords(arrayResult, maxIterator, result, d);
        result = (Set<T>) arrayResult.get("list");
        arrayResult = removeByIndex(result, arrayResult, maxIterator / 2);
        arrayResult = findByIndex(result, arrayResult, maxIterator / 2);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("zfinal_time", estimated);

        arrayResult.remove("list");
        return arrayResult;
    }

    public Map<String, Object> launch(Stack<T> result, int maxIterator, T d) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        arrayResult = addAllRecords(arrayResult, maxIterator, result, d);
        result = (Stack<T>) arrayResult.get("list");
        arrayResult = removeByIndex(result, arrayResult, maxIterator / 2);
        arrayResult = findByIndex(result, arrayResult, maxIterator / 2);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("zfinal_time", estimated);

        arrayResult.remove("list");
        return arrayResult;
    }
    public Map<String, Object> launch(Queue<T> result, int maxIterator, T d) {
        Long startTime = System.nanoTime();
        Map<String, Object> arrayResult = new TreeMap<>();
        arrayResult = addAllRecords(arrayResult, maxIterator, result, d);
        result = (Queue<T>) arrayResult.get("list");
        arrayResult = removeByIndex(result, arrayResult, maxIterator / 2);
        arrayResult = findByIndex(result, arrayResult, maxIterator / 2);
        BigDecimal estimated = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("zfinal_time", estimated);

        arrayResult.remove("list");
        return arrayResult;
    }


    public Map<String, Object> removeByIndex(String[] result , Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();
        String[] aCopy = new String[result.length - 1];
        for (int i = 0, k = 0; i < result.length; i++) {
            if (i == recordId) {
                continue;
            }
            aCopy[k++] = result[i];
        }
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("removed_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }
    public Map<String, Object> removeByIndex(Stack<T> result , Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();
        result.remove(recordId);
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        //   String key = result.getClass().getSimpleName()+"_removed_entry_"+recordId+"_time_take_in_";
        arrayResult.put("removed_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> removeByIndex(Queue<T> result , Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();

        //result.remove(recordId);
        Iterator<T> iterator = result.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            iterator.next();
            if(index==recordId) {
                iterator.remove();
                break;
            }
            index++;
        }

        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        //   String key = result.getClass().getSimpleName()+"_removed_entry_"+recordId+"_time_take_in_";
        arrayResult.put("removed_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> removeByIndex(List<T> result , Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();
        result.remove(recordId);
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        //   String key = result.getClass().getSimpleName()+"_removed_entry_"+recordId+"_time_take_in_";
        arrayResult.put("removed_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> removeByIndex(Map<Integer,T> result , Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();
        result.remove(recordId);
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("removed_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> removeByIndex(Set<T> result , Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();
        //result.remove(recordId);
        Iterator<T> iterator = result.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            iterator.next();
            if(index==recordId) {
                iterator.remove();
                break;
            }
            index++;
        }
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("removed_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }



    public Map<String, Object> addAllRecords(Map<String, Object> arrayResult, int maxIterator, String[] result, T d) {
        Long startTime=System.nanoTime();
        for (int i=0; i < maxIterator; i++) {
            result[i]=(String)d;
        }
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("added_all", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }
    public Map<String, Object> addAllRecords(Map<String, Object> arrayResult, int maxIterator, List<T> result, T d) {
        Long startTime=System.nanoTime();
        for (int i=0; i < maxIterator; i++) {
            result.add(d);
        }
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("added_all", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> addAllRecords(Map<String, Object> arrayResult, int maxIterator,Map<Integer,T> result, T d) {
        Long startTime=System.nanoTime();
        for (int i=0; i < maxIterator; i++) {
            result.put(i, d);
        }
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("added_all", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> addAllRecords(Map<String, Object> arrayResult, int maxIterator, Set<T> result, T d) {
        Long startTime=System.nanoTime();
        for (int i=0; i < maxIterator; i++) {
            result.add(d);
        }
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("added_all", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> addAllRecords(Map<String, Object> arrayResult, int maxIterator, Stack<T> result, T d) {
        Long startTime=System.nanoTime();
        for (int i=0; i < maxIterator; i++) {
            result.add(d);
        }
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("added_all", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> addAllRecords(Map<String, Object> arrayResult, int maxIterator, Queue<T> result, T d) {
        Long startTime=System.nanoTime();
        for (int i=0; i < maxIterator; i++) {
            result.add(d);
        }
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("added_all", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> findByIndex(String[] result , Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();
        int index = 0;
        for(String element : result){
            if(index == recordId){
                //We found record
                break;
            }
            index++;
        }
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        String key = result.getClass().getSimpleName()+"_got_entry_"+recordId+"_time_take_in_";
        arrayResult.put("got_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }
    public Map<String, Object> findByIndex(List<T> result , Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();
        result.get(recordId);
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        String key = result.getClass().getSimpleName()+"_got_entry_"+recordId+"_time_take_in_";
        arrayResult.put("got_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> findByIndex(Map<Integer,T> result, Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();
        result.get(recordId);
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("got_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }
    public Map<String, Object> findByIndex(Stack<T> result , Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();
        result.get(recordId);
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        //String key = result.getClass().getSimpleName()+"_got_entry_"+recordId+"_time_take_in_";
        arrayResult.put("got_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> findByIndex(Queue<T> result , Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();
        //result.get(recordId);
        Iterator<T> iterator = result.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            T current = iterator.next();
            if(index==recordId) {
               // iterator.remove();
                break;
            }
            index++;
        }

        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        //String key = result.getClass().getSimpleName()+"_got_entry_"+recordId+"_time_take_in_";
        arrayResult.put("got_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public Map<String, Object> findByIndex(Set<T> result , Map<String, Object> arrayResult, int recordId) {
        Long startTime=System.nanoTime();
        //Convert set to list to get by index
        //List<T> list = new ArrayList<T>( result );
        //list.get(recordId);
        int index = 0;
        for(T element : result){
            if(index == recordId){
                //We found record
                break;
            }
            index++;
        }

        /*
        Iterator<T> iterator = result.iterator();
        int index = 0;
        T foundResult=null;
        while(iterator.hasNext()) {
            T dd = iterator.next();
            if(index==recordId) {
                foundResult = dd;
                break;
            }
            index++;
        }
        */
        BigDecimal listCompletedN = estimateTime(System.nanoTime()-startTime);
        arrayResult.put("got_entry", listCompletedN);
        arrayResult.put("list", result);
        return arrayResult;
    }

    public BigDecimal estimateTime(long dt) {
        //double myDouble = dt/1000000.; // 1_000_000. breaks cobertura
        return new BigDecimal(String.valueOf(dt/1000000.)).stripTrailingZeros();
    }

}



