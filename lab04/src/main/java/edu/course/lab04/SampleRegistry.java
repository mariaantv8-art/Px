package edu.course.lab04;

import java.util.HashMap;
import java.util.Map;

public class SampleRegistry<K> {
    private final Map<K, Double> map = new HashMap<>();

    public void put(K id, Double value) {
        map.put(id, value);
    }

    public Double get(K id) {
        return map.get(id);
    }

    public void remove(K id) {
        map.remove(id);
    }

    public boolean containsKey(K id) {
        return map.containsKey(id);
    }

    public int size() {
        return map.size();
    }
}