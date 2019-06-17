package ru.sberbank.school.task06;

import java.util.HashMap;
import java.util.Map;

public class CountHashMap<E> implements CountMap<E> {

    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E o) {
        map.merge(o, 1, Integer::sum);
    }

    @Override
    public int getCount(E o) {
        return map.getOrDefault(o, 0);
    }

    @Override
    public int remove(E o) {
        return map.containsKey(o) ? map.remove(o) : 0;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends E> source) {
        source.toMap().forEach((k, v) -> map.merge(k, v, Integer::sum));
    }

    @Override
    public Map<E, Integer> toMap() {
        return new HashMap<>(map);
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        destination.putAll(map);
    }
}
