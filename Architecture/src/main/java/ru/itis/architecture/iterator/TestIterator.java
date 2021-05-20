package ru.itis.architecture.iterator;

import java.util.ArrayList;
import java.util.List;

public class TestIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        HandMadeIterator<String> iterator = new HandMadeIterator<>(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
