package ru.sberbank.school.task06;

import java.util.HashMap;
import java.util.Map;

public class CountMapClass<E> implements CountMap<E> {

    private Map<E, Integer> map = new HashMap<>();

    /**
     * Добавление элепмента в контейнер.
     *
     * @param o элемент для добавления
     */
    @Override
    public void add(E o) {
        map.merge(o, 1, Integer::sum);
    }

    /**
     * Получение количества вхождений данного элемента.
     *
     * @param o элемент
     * @return количество вхождений эелемента
     */
    @Override
    public int getCount(E o) {
        return map.getOrDefault(o, 0);
    }

    /**
     * Удаление элемента из контейнера (полностью).
     *
     * @param o элемент
     * @return количество добавлений элемента(до удаления)
     */
    @Override
    public int remove(E o) {
        return map.containsKey(o) ? map.remove(o) : 0;
    }

    /**
     * Получение количества разных элементов.
     *
     * @return количество разных элементов.
     */
    @Override
    public int size() {
        return map.size();
    }

    /**
     * Добавление всех элементов из коллекции source в текущий контейнер. При совпадениии ключей,
     * счётчики увеличивается.
     *
     * @param source коллекция - источник
     */
    @Override
    public void addAll(CountMap<? extends E> source) {
        source.toMap().forEach((k, v) -> map.merge(k, v, Integer::sum));
    }

    /**
     * Трансформация текущего контейнеру к контейнеру java.util.Map. Ключ - добавленный элемент,
     * значение - количество его добавлений.
     *
     * @return контейнер java.util.Map
     */
    @Override
    public Map<E, Integer> toMap() {
        return new HashMap<>(map) ;
    }

    /**
     * Тот же контракт, что и у toMap(), но результат записать в destination.
     *
     * @param destination
     */
    @Override
    public void toMap(Map<? super E, Integer> destination) {
        map.forEach((k, v) -> destination.merge(k, v, Integer::sum));
    }

}
