package ru.itis.architecture.iterator;

public class Main {

    public static void main(String[] args) {
        //Создаем коллекцию
        MyCollection<String> myCollection = new MyCollectionImpl<>();

        //Добавляем элементы
        myCollection.add("test1");
        myCollection.add("test2");
        myCollection.add("test3");
        myCollection.add("test4");

        //Берем итератор из коллекции
        MyIterator<String> myIterator = myCollection.iterator();
        //Тестируем работу итератора
        while(myIterator.hasNext()){
            System.out.println(myIterator.next());
        }
    }
}
