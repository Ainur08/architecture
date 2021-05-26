package ru.itis.architecture.iterator;

public interface Collection<T> extends Iterable<T> {
    void add(T item);
    T get(int index);
    void remove(int index);
    int size();
}
