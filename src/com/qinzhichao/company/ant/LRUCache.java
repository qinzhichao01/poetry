package com.qinzhichao.company.ant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinzhichao
 * created at 2023/4/27 21:23
 **/
public class LRUCache {


    private Map<Integer, Integer> keyValMap = new HashMap<>();
    private Map<Integer, Integer> countMap = new HashMap<>();

    private int capacity;
    private int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public int get(int key) {
        Integer val = keyValMap.get(key);
        if (val == null) {
            return -1;
        }
        countMap.put(key, countMap.getOrDefault(key, 0));
        return val;
    }

    public void put(int key, int value) {
        if (keyValMap.get(key) != null) {
            keyValMap.put(key, value);
            countMap.put(key, countMap.get(key) + 1);
            return;
        }

        if (this.capacity == count) {
            // 淘汰老的
            Integer obj = null;
            int c = Integer.MAX_VALUE;
            for (Integer integer : countMap.keySet()) {
                Integer v = countMap.get(integer);
                if (v < c) {
                    obj = integer;
                    c = v;
                }
            }
            keyValMap.remove(obj);
        }
        keyValMap.put(key, value);
        countMap.put(key, countMap.getOrDefault(key, 0) + 1);

    }


}
