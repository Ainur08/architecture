package ru.itis.architecture.iterator;

public class MyCollectionImpl<T> implements MyCollection<T> {
    //Дефолтный размер коллекции
    private static final int DEFAULT_CAPACITY = 10;
    //Размер коллекции
    private int size = 0;
    //Элементы коллекции
    private Object[] elements;

    //Конструктор без параметров, заводим коллекцию с дефолтным размером
    MyCollectionImpl(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    //Конструктор с заданным размером
    MyCollectionImpl(int capacity){
        elements = new Object[capacity];
    }

    //Возвращаем размер коллекции
    @Override
    public int size() {
        return this.size;
    }

    //Возвращаем итератор
    @Override
    public MyIterator<T> iterator() {
        return new MyIteratorImpl<>(this);
    }

    //Добавляем элемент в коллекцию
    @Override
    public boolean add(T t) {
        elements[size++] = t;
        return true;
    }

    //Возвращаем элемент по индексу
    @Override
    public T get(int index) {
        return (T) elements[index];
    }
}
