package ru.itis.architecture.iterator.interfaces;

public interface MyIterator<E> {
    // Возвращает true, если есть элементы, и false, если больше нет элементов
    boolean hasNext();

    // Возвращает следующий элемент
    E next();
}
