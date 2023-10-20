package net.proselyte.basepatterns.core2.pecs;

import java.util.ArrayList;
import java.util.List;

public class TestPecs {
    public static void process(List<? extends Class2> list) { //Подклассы Class2
        // Ваш код обработки коллекции
        for (Class0 item : list) {
            // Доступ к элементам коллекции типа Class1 или его подклассов
            System.out.println(item);
        }
    //    System.out.println(list.get(0));
    }


    public static void main(String[] args) {


        List<Class2> myList = List.of(new Class2(), new Class3());
    //     List<Class3> myList2 = List.of(new Class3(), new Class3());

        // Вызываем метод process, передавая список myList
        process(myList);

    //    someMethod(myList);

    }
}
class Class0  {

}

class Class1 extends Class0{

}
class Class2 extends Class1{

}
class Class3 extends Class2{

}
class Class4 extends Class3{

        }

class Class5 extends Class4{

        }
