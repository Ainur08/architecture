package ru.itis.architecture.iterator;

public class Main {
    public static void main(String[] args) {
        Vedro<Shar> vedro = new Vedro<>();

        vedro.add(new Shar("1"));
        vedro.add(new Shar("2"));
        vedro.add(new Shar("3"));
        vedro.add(new Shar("4"));
        vedro.add(new Shar("5"));
        vedro.add(new Shar("6"));

        // инициализация итератора
        Iterator iterator = vedro.iterator();

        // вывод списка
        while (iterator.hasNext()) {
            System.out.println(((Shar) iterator.next()).getText());
        }

        System.out.println("");

        // удаление последнего элемента в списке
        iterator.remove();
        iterator = vedro.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Shar) iterator.next()).getText());
        }

        iterator = vedro.iterator();

        // удаление второго элемента в списке
        iterator.next();
        iterator.next();
        iterator.remove();

        System.out.println("");

        iterator = vedro.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Shar) iterator.next()).getText());
        }

    }
}
