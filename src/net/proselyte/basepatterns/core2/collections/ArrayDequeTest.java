package net.proselyte.basepatterns.core2.collections;

import java.util.ArrayDeque;

public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<String> states = new ArrayDeque<>();
        // стандартное добавление элементов
        states.add("Germany");
        states.addFirst("France"); // добавляем элемент в самое начало
        states.push("Great Britain"); // добавляем элемент в самое начало
        states.addLast("Spain"); // добавляем элемент в конец коллекции
        states.add("Italy");

        // получаем первый элемент без удаления
        String sFirst = states.getFirst();
        System.out.println(sFirst);     // Great Britain
        // получаем последний элемент без удаления
        String sLast = states.getLast();
        System.out.println(sLast);      // Italy

        System.out.printf("Queue size: %d \n", states.size());  // 5
        System.out.println("Перебор перед удалением pop");
        for(String p : states){

            System.out.println(p);
        }
        // перебор коллекции
        System.out.println("Перебор с удалением");
        while(states.peek()!=null){
            // извлечение c начала
            System.out.println(states.pop());
        }
        System.out.println("Перебор после удаления");
        while(states.peek()!=null){
            // извлечение c начала
            System.out.println(states.peek());
        }
        // очередь из объектов Person
        ArrayDeque<Person> people = new ArrayDeque<>();
        people.addFirst(new Person("Tom"));
        people.addLast(new Person("Nick"));
        // перебор без извлечения
        System.out.println("Перебор");
        for(Person p : people){

            System.out.println(p.getName());
        }
    }
}
class Person{

    private String name;
    public Person(String value){

        name=value;
    }
    String getName(){return name;}
}
