package ru.itis.architecture.iterator.interfaces;

public interface MyIterable<E> {
    // Возвращает итератор для итерируемых объектов
    MyIterator<E> myIterator();
}
