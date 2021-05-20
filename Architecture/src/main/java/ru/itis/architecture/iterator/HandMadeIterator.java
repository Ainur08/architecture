package ru.itis.architecture.iterator;

import java.util.Collection;
import java.util.Iterator;

public class HandMadeIterator<T> implements Iterator<T> {
    Collection<T> collection;
    private int index = 0;

    public HandMadeIterator(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return        index < collection.size();
    }

    @Override
    public T next() {
        return (T) collection.toArray()[index++];
    }
}
