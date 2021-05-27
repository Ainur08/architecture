package ru.itis.architecture.iterator;

public interface MyCollection<T> extends MyIterable<T> {

    int size();

    MyIterator<T> iterator();

    boolean add(T t);

    T get(int index);

}
