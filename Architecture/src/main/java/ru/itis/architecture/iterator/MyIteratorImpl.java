package ru.itis.architecture.iterator;

public class MyIteratorImpl<T> implements MyIterator<T> {

    private MyCollection<T> myCollection;
    private int cursor =  0;

    public MyIteratorImpl(MyCollection<T> myCollection){
        this.myCollection = myCollection;
    }

    @Override
    public boolean hasNext() {
        return cursor < myCollection.size();
    }

    @Override
    public T next() {
        return myCollection.get(cursor++);
    }
}
