package ru.itis.architecture.iterator;

public class MyCollectionImpl<T> implements MyCollection<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    MyCollectionImpl(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    MyCollectionImpl(int capacity){
        elements = new Object[capacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyIteratorImpl<>(this);
    }

    @Override
    public boolean add(T t) {
        elements[size++] = t;
        return true;
    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }
}
