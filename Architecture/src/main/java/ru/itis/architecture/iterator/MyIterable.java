package ru.itis.architecture.iterator;

public interface MyIterable<T> {

    //Кастомный интерфейс для классов с итератором
    MyIterator<T> iterator();

}
