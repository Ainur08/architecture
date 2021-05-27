package ru.itis.architecture.iterator;

public class Main {

    public static void main(String[] args) {
        MyCollection<String> myCollection = new MyCollectionImpl<>();

        myCollection.add("test1");
        myCollection.add("test2");
        myCollection.add("test3");
        myCollection.add("test4");

        MyIterator<String> myIterator = myCollection.iterator();
        while(myIterator.hasNext()){
            System.out.println(myIterator.next());
        }
    }
}
