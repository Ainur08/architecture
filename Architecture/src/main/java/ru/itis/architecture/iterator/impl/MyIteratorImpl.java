package ru.itis.architecture.iterator.impl;

import ru.itis.architecture.iterator.interfaces.MyCollection;
import ru.itis.architecture.iterator.interfaces.MyIterator;

public class MyIteratorImpl<E> implements MyIterator<E> {
    // Интерфейс коллекции
    private MyCollection<E> myCollection;

    // Указатель на текущий элемент
    private int current;

    // Инициализация коллекции
    public MyIteratorImpl(MyCollection<E> myCollection) {
        this.myCollection = myCollection;
    }

    @Override
    public boolean hasNext() {
        return current < myCollection.size();
    }

    @Override
    public E next() {
        return myCollection.get(current++);
    }
}
