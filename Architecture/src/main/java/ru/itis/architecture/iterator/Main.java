package ru.itis.architecture.iterator;

import ru.itis.architecture.iterator.impl.MyCollectionImpl;
import ru.itis.architecture.iterator.interfaces.MyCollection;
import ru.itis.architecture.iterator.interfaces.MyIterator;

public class Main {
    public static void main(String[] args) {
        // Создаём свою коллекцию
        MyCollection myCollection = new MyCollectionImpl();

        // Добавляем элементы
        myCollection.add(1);
        myCollection.add(2);
        myCollection.add(3);
        myCollection.add(4);
        myCollection.add(5);
        myCollection.add(6);

        //Получаем итератор из коллекции
        MyIterator<Integer> myIterator = myCollection.myIterator();

        // Выводим элементы с помощью итератора
        while (myIterator.hasNext()){
            System.out.println(myIterator.next());
        }
    }
}
