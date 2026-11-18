package edu.course.lab04;

import java.util.HashMap;
import java.util.Map;

public class SampleRegistry {
    private final Map<SampleId, Double> map = new HashMap<>();

    public void put(SampleId id, Double value) {
        map.put(id, value);
    }

    public Double get(SampleId id) {
        return map.get(id);
    }

    public void remove(SampleId id) {
        map.remove(id);
    }

    public boolean containsKey(SampleId id) {
        return map.containsKey(id);
    }

    public int size() {
        return map.size();
    }
}