package ru.itis.architecture.iterator.interfaces;

public interface MyCollection<E> extends MyIterable<E> {
    // Возвращает размер коллекции
    int size();

    // Возвращает итератор
    MyIterator<E> myIterator();

    // Добавляет элемент
    void add(E e);

    // Возвращает элемент по индексу
    E get(int i);
}
