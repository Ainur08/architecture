package ru.itis.architecture.iterator;

public interface MyCollection<T> extends MyIterable<T> {

    //Размер коллекции
    int size();

    //Итератор
    MyIterator<T> iterator();

    //Добавление элемента в коллекцию
    boolean add(T t);

    //Берем элемент коллекции по индексу
    T get(int index);

}
