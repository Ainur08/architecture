package ru.itis.architecture.iterator;

public class MyIteratorImpl<T> implements MyIterator<T> {

    //Кастомная коллекция
    private MyCollection<T> myCollection;
    //Указатель текущего элемента
    private int cursor =  0;

    //Конструктор, в которым мы передаем кастомную коллекцию
    public MyIteratorImpl(MyCollection<T> myCollection){
        this.myCollection = myCollection;
    }

    //Проверка что счетчик курсора меньше размера коллекции
    @Override
    public boolean hasNext() {
        return cursor < myCollection.size();
    }

    //Получение следующего элемента коллекции, увеличиваем счетчик курсора
    @Override
    public T next() {
        return myCollection.get(cursor++);
    }
}
