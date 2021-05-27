package ru.itis.architecture.iterator;

public interface MyIterator<T>{

    //Проверка наличия следующего элемента
    boolean hasNext();

    //Получение следующего элемента
    T next();

}
