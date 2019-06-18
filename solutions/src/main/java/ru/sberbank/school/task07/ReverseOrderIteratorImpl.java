package ru.sberbank.school.task07;

import java.util.List;
import java.util.ListIterator;

public class ReverseOrderIteratorImpl<E> implements ReverseOrderIterator<E> {

    private ListIterator<E> iterator;

    public ReverseOrderIteratorImpl(List<E> list) {
        this.iterator = list.listIterator(list.size());
    }

    @Override
    public boolean hasNext() {
        return iterator.hasPrevious();
    }

    @Override
    public E next() {
        return iterator.previous();
    }

}
