package net.proselyte.basepatterns.core2.collections;

import java.util.ArrayList;
import java.util.List;
/*
Collection
boolean add (E item): добавляет в коллекцию объект item. При удачном добавлении возвращает true, при неудачном - false

boolean addAll (Collection<? extends E> col): добавляет в коллекцию все элементы из коллекции col. При удачном добавлении возвращает true, при неудачном - false

void clear (): удаляет все элементы из коллекции

boolean contains (Object item): возвращает true, если объект item содержится в коллекции, иначе возвращает false

boolean isEmpty (): возвращает true, если коллекция пуста, иначе возвращает false

Iterator<E> iterator (): возвращает объект Iterator для обхода элементов коллекции

boolean remove (Object item): возвращает true, если объект item удачно удален из коллекции, иначе возвращается false

boolean removeAll (Collection<?> col): удаляет все объекты коллекции col из текущей коллекции. Если текущая коллекция изменилась, возвращает true, иначе возвращается false

boolean retainAll (Collection<?> col): удаляет все объекты из текущей коллекции, кроме тех, которые содержатся в коллекции col. Если текущая коллекция после удаления изменилась, возвращает true, иначе возвращается false

int size (): возвращает число элементов в коллекции

Object[] toArray (): возвращает массив, содержащий все элементы коллекции

List
Для создания простых списков применяется интерфейс List, который расширяет функцональность интерфейса Collection.
Некоторые наиболее часто используемые методы интерфейса List:

void add(int index, E obj): добавляет в список по индексу index объект obj

boolean addAll(int index, Collection<? extends E> col): добавляет в список по индексу index все элементы коллекции col. Если в результате добавления список был изменен, то возвращается true, иначе возвращается false

E get(int index): возвращает объект из списка по индексу index

int indexOf(Object obj): возвращает индекс первого вхождения объекта obj в список. Если объект не найден, то возвращается -1

int lastIndexOf(Object obj): возвращает индекс последнего вхождения объекта obj в список. Если объект не найден, то возвращается -1

ListIterator<E> listIterator (): возвращает объект ListIterator для обхода элементов списка

static <E> List<E> of(элементы): создает из набора элементов объект List

E remove(int index): удаляет объект из списка по индексу index, возвращая при этом удаленный объект

E set(int index, E obj): присваивает значение объекта obj элементу, который находится по индексу index

void sort(Comparator<? super E> comp): сортирует список с помощью компаратора comp

List<E> subList(int start, int end): получает набор элементов, которые находятся в списке между индексами start и end

 */

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> people = new ArrayList<>();
        // добавим в список ряд элементов
        people.add("Tom");
        people.add("Alice");
        people.add("Kate");
        people.add("Sam");
        people.add(1, "Bob"); // добавляем элемент по индексу 1

        System.out.println(people.get(1));// получаем 2-й объект
        people.set(1, "Robert"); // установка нового значения для 2-го объекта

        System.out.printf("ArrayList has %d elements \n", people.size());
        for(String person : people){
            System.out.println(person);
        }
        // проверяем наличие элемента
        if(people.contains("Tom")){
            System.out.println("ArrayList contains Tom");
        }

        // удалим несколько объектов
        // удаление конкретного элемента
        people.remove("Robert");
        // удаление по индексу
        people.remove(0);
        Object[] peopleArray = people.toArray();
        for(Object person : peopleArray){
           System.out.println(person);
        }
        System.out.println(peopleArray.toString());
    }

}

