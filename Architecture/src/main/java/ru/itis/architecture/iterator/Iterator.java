package ru.itis.architecture.iterator;

public interface Iterator<T> {
    T next();
    boolean hasNext();
    void remove();
}
