package ru.itis.architecture.iterator;

public class Vedro<T> implements Collection<T>{
    private Object[] array = new Object[16];
    private int counter = 0;

    @Override
    public void add(T item) {
        if (counter == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, counter);
            array = newArray;
        }
        array[counter++] = item;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < counter; i++)
            array[i] = array[i + 1];
        array[counter] = null;
        counter--;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public Iterator<T> iterator() {
        return new CollectionIterator<>(this);
    }
}
