package net.proselyte.basepatterns.core2.collections;
/*
Среди методов интерфейса Map можно выделить следующие:
void clear(): очищает коллекцию
boolean containsKey(Object k): возвращает true, если коллекция содержит ключ k
boolean containsValue(Object v): возвращает true, если коллекция содержит значение v
Set<Map.Entry<K, V>> entrySet(): возвращает набор элементов коллекции. Все элементы представляют объект Map.Entry
boolean equals(Object obj): возвращает true, если коллекция идентична коллекции, передаваемой через параметр obj
boolean isEmpty: возвращает true, если коллекция пуста
V get(Object k): возвращает значение объекта, ключ которого равен k. Если такого элемента не окажется, то возвращается значение null
V getOrDefault(Object k, V defaultValue): возвращает значение объекта, ключ которого равен k. Если такого элемента не окажется, то возвращается значение defaultVlue
V put(K k, V v): помещает в коллекцию новый объект с ключом k и значением v. Если в коллекции уже есть объект с подобным ключом, то он перезаписывается. После добавления возвращает предыдущее значение для ключа k, если он уже был в коллекции. Если же ключа еще не было в коллекции, то возвращается значение null
V putIfAbsent(K k, V v): помещает в коллекцию новый объект с ключом k и значением v, если в коллекции еще нет элемента с подобным ключом.
Set<K> keySet(): возвращает набор всех ключей отображения
Collection<V> values(): возвращает набор всех значений отображения
void putAll(Map<? extends K, ? extends V> map): добавляет в коллекцию все объекты из отображения map
V remove(Object k): удаляет объект с ключом k
int size(): возвращает количество элементов коллекции

Чтобы положить объект в коллекцию, используется метод put, а чтобы получить по ключу - метод get. Реализация интерфейса Map также позволяет получить наборы как ключей, так и значений. А метод entrySet() возвращает набор всех элементов в виде объектов Map.Entry<K, V>.
Обобщенный интерфейс Map.Entry<K, V> представляет объект с ключом типа K и значением типа V и определяет следующие методы:
boolean equals(Object obj): возвращает true, если объект obj, представляющий интерфейс Map.Entry, идентичен текущему
K getKey(): возвращает ключ объекта отображения
V getValue(): возвращает значение объекта отображения
V setValue(V v): устанавливает для текущего объекта значение v
int hashCode(): возвращает хеш-код данного объекта
При переборе объектов отображения мы будем оперировать этими методами для работы с ключами и значениями объектов.
 */

import java.util.*;

public class HashMapTest {
    /*
    Базовым классом для всех отображений является абстрактный класс AbstractMap, который реализует большую часть методов интерфейса Map.
    Наиболее распространенным классом отображений является HashMap, который реализует интерфейс Map и наследуется от класса AbstractMap.
    Получение и установка значения происходит за O(1) при условии хорошего хэшкода для ключа.
    Для коллизий используется поле next в Node, которое указывает на следующий Node(добавленный в конец).
    Начиная с java 1.8, если  Node в 1 ячейке больше 8, связанный список(O(N)) преобразуется  в дерево(O(LogN)).
    Если надо получить по ключу из map значение: сравнивается key по equals.

    1 Получение элемента по индексу: get
    2 Получение элемента по значению:  искать в коде ниже // Значение, которое вы хотите найти
    3 Добавление элемента в конец/середину(не гарантирует порядок): put
    4 Удаление элемента с конца/середины(не гарантирует порядок): remove // Удаление элемента по ключу

    new HashMap<Integer, String>(initialCapacity, loadFactor);

     */
    public static void main(String[] args) {
        Map<Integer, String> states = new HashMap<Integer, String>();
        states.put(1, "Germany");
        states.put(2, "Spain");
        states.put(4, "France");
        states.put(3, "Italy");

        // получим объект по ключу 2
        String first = states.get(2);
        System.out.println(first);
        // получим весь набор ключей
        Set<Integer> keys = states.keySet();
        // получить набор всех значений
        Collection<String> values = states.values();
        //заменить элемент
        states.replace(1, "Poland");
        // удаление элемента по ключу 2
        states.remove(2);
        // перебор элементов
        for (Map.Entry<Integer, String> item : states.entrySet()) {

            System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
        }

        Map<String, Person> people = new HashMap<String, Person>();
        Person tom = new Person("Tom");
        people.put("1240i54", tom);
        people.put("1564i55", new Person("Bill"));
        people.put("4540i56", new Person("Nick"));

        for (Map.Entry<String, Person> item : people.entrySet()) {

            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
        }
        System.out.println(people.keySet()); //множество ключей
        System.out.println(people.values()); // коллекция значений
        System.out.println(people.entrySet()); // множество всех значений коллекций пар
        Object valueToFind = tom; // Значение, которое вы хотите найти
        Optional<String> result = people.entrySet().stream()
                .filter(entry -> valueToFind.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        if (result.isPresent()) {
            System.out.println("Ключ для значения " + valueToFind + ": " + result.get());
        } else {
            System.out.println("Значение не найдено в HashMap.");
        }
        // Удаление элемента по ключу
        String keyToRemove = "4540i56";
        people.remove(keyToRemove);

        // Проверка, что элемент удален
        if (people.containsKey(keyToRemove)) {
            System.out.println("Элемент не удален.");
        } else {
            System.out.println("Элемент успешно удален.");
        }
    }
}


