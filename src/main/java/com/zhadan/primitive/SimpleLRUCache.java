package com.zhadan.primitive;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by azhadan on 7/23/13.
 */
public class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;


    public SimpleLRUCache(int capacity) {
        super(capacity + 1, 1.1f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > capacity;
    }
}
