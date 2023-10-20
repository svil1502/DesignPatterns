package net.proselyte.basepatterns.creational.abstractfactory2;

public class AbstractFactoryLesson {
    public static void main(String[] args) {
        Factory carFactory = new Abstractfactory().createFactory("Car");
        Factory tankFactory = new Abstractfactory().createFactory("Tank");
        Car toyota = carFactory.createCar("Toyota");
        toyota.drive();
        Tank t31 = tankFactory.createTank("Т31");
        t31.drive();

    }
}
interface Car {
    void drive();
}
class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}

interface Tank {
    void drive();
}
class T31 implements Tank {
    @Override
    public void drive() {
        System.out.println("drive T31");
    }
}

interface Factory {
    Car createCar(String typeOfCar);
    Tank createTank(String typeOfTank);
}

class CarFactory implements Factory {
    public Car createCar (String typeOfCar) {
        switch (typeOfCar) {
            case "Toyota" : return new Toyota();
            default: return null;
        }
    }

    @Override
    public Tank createTank(String typeOfTank) {
        return null;
    }
}
class TankFactory implements Factory {
    public Tank createTank (String typeOfTank) {
        switch (typeOfTank) {
            case "Т31" : return new T31();
            default: return null;
        }
    }

    @Override
    public Car createCar(String typeOfCar) {
        return null;
    }
}
class Abstractfactory {
    Factory createFactory(String typeOfFactory) {
        switch (typeOfFactory) {
            case "Car" : return new CarFactory();
            case "Tank" : return new TankFactory();
            default: return null;
        }
    }
}

