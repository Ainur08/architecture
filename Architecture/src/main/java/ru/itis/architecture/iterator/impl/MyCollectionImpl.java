package ru.itis.architecture.iterator.impl;

import ru.itis.architecture.iterator.interfaces.MyCollection;
import ru.itis.architecture.iterator.interfaces.MyIterator;

public class MyCollectionImpl<E> implements MyCollection<E> {
    // максимальный размер массива
    private static final int MAX_CAPACITY = 100;

    // Указатель на текующий элемент
    private int current;

    // Массив объектов
    private Object[] objects;

    // Инициализация массива объектов с максимальным размером
    public MyCollectionImpl() {
        objects = new Object[MAX_CAPACITY];
    }

    @Override
    public int size() {
        return current;
    }

    @Override
    public MyIterator<E> myIterator() {
        return new MyIteratorImpl<>(this);
    }

    @Override
    public void add(E e) {
        objects[current] = e;
        current += 1;
    }

    @Override
    public E get(int i) {
        return (E) objects[i];
    }
}
