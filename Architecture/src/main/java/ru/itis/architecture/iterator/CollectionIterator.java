package ru.itis.architecture.iterator;
import java.util.NoSuchElementException;

public class CollectionIterator<T> implements Iterator<T> {
    int cursor = 0;
    Collection<T> collection;

    public CollectionIterator(Collection<T> collection) {
        this.collection = collection;
    }

    // проверяет на наличие следующего элемента
    public boolean hasNext() {
        return this.cursor != collection.size();
    }

    // получение следующего элемента и переход к нему (т.е. он теперь текущий)
    public T next() {
        if (hasNext()) {
            return collection.get(cursor++);
        } else {
            throw new NoSuchElementException();
        }
    }

    // удаление текущего элемента
    public void remove() {
        if (cursor != 0) {
            collection.remove(--cursor);
        } else {
            throw new IllegalArgumentException("Next wasn't call");
        }
    }
}