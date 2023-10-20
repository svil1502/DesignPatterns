package net.proselyte.basepatterns.core2.pecs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*
Ковариантность и контрвариантность обобщенных типов Java
Fruit
Citrus
Orange
BigRoundOrange
 */
public class Main {
    static class Fruit {
        int weight;
    }
    static class Citrus extends Fruit {
        int weight;
    }
    static class Orange extends Citrus {
        int color;
    }
    static class BigRoundOrange extends Orange {
        int size = 100;
    }
    /*
    Как с помощью этой функции вычислять вес для всех
    потомков класса Citrus.
     */
    private static int totalWeight(ArrayList<? extends Citrus> oranges) {
        int weight = 0;
        for(int i = 0; i < oranges.size(); i++) {
            weight += oranges.get(i).weight;
        }
        return  weight;
    }

    private static void addOrangees(ArrayList<? super Orange> oranges) { //Orange и его предки
            for(int i = 0; i < 10; i++) {
                oranges.add(new BigRoundOrange());
            }
    }
    public static void main(String[] args) {


        Fruit fruit = new Fruit();
        Citrus citrus = new Citrus();
        Orange orange = new Orange();
        citrus = orange;

        ArrayList<Citrus> citrusArrays = new ArrayList<>();
        ArrayList<Orange> orangeArrays = new ArrayList<>();
        Iterator<Orange> iterator = orangeArrays.iterator();
        /*
        Инвариантность - когда Arraylist-у присваивается ArrayList такого же типа(подставить в качестве параметра), нельзя наследников или потомков.
        Обобщенные классы являются инвариантными.
        Инвариантный тип - это тип, который не может быть заменен на другой тип. Например, List<String> не может быть присвоен List<Object>.
         В Java это означает, что List<String> не является подтипом List<Object>.

        Ковариантный тип - это тип, который может быть заменен на его подтип. Например, List<? extends Number> может быть присвоен List<Integer>.
         В Java это означает, что List<Integer> является подтипом List<? extends Number>.
        Ковариантность -  wildcard <? extends Citrus>, когда можно подставить в качестве параметра(=что можно присвоить) в метод Citrus и всех его наследников ArrayList(Orange).
         Читать из ArrayLIst можно сам класс Citrus и его предков(Fruit),
         но записать нельзя.

        Контрвариантный тип - это тип, который может быть заменен на его супертип. Например, List<? super Integer> может быть присвоен List<Number>.
         В Java это означает, что List<Number> является супертипом List<? super Integer>.
         Контрвариантность типов - wildcard <? super Orange>, прочесть можно только Object ob = oranges.get(0),
         но добавлять Orange и его потомков orangres.add(new BigRoundOrange()). В качестве параметра можно передавать любой список,
         содержащий предков Orange(=что можно присвоить), читать из списка можно только Object, писать в список можно Orange и его наследников(BigRoundOrange).
         Extends используется в классах чтобы из них читать - в Producer, а Super - куда писать для Consumer
         */
        //citrusList = orangeArrays; ошибка
        totalWeight(orangeArrays);
        citrusArrays.add(new Orange());
        addOrangees(citrusArrays);

    }

}
