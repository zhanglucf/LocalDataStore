package lambdasinaction.generics;


import java.util.ArrayList;
import java.util.List;

interface Skill{
    void play();
}

class Animal{
    int speed;
    String name;
}

class Dog extends Animal implements Comparable<Dog>{
    @Override
    public int compareTo(Dog o) {
        return Integer.compare(this.speed, o.speed);
    }
}

class HaShiQi extends Dog{}


class Cat extends Animal implements Comparable<Animal>{
    @Override
    public int compareTo(Animal o) {
        return Integer.compare(this.speed, o.speed);
    }
}

class XiaoHuaMao extends Cat{}

class Car implements Comparable<Car>{

    @Override
    public int compareTo(Car o) {
        return 0;
    }
}

class Fish{}

public class GenericStudy {

    public <T extends Comparable<? super T>> void method(T t,T t2){
           t.compareTo(t2);
    }

    public <T extends Comparable<? super T>> void method2(List<T> list){
        for (T t : list) {
            t.compareTo(t);
        }
    }

    public <T extends Comparable<? super T>> void method3(List<? extends T> list) {
        for (T t : list) {
            t.compareTo(t);
        }
    }
    public static void main(String[] args) {
        final GenericStudy genericStudy = new GenericStudy();
        genericStudy.method(new Dog(),new Dog());
        genericStudy.method(new Cat(),new Cat());
        genericStudy.method(new Car(),new Car());
//        genericStudy.method(new Fish(),new Fish());

        final ArrayList<Dog> dogs = new ArrayList<>();
        final ArrayList<HaShiQi> haShiQis = new ArrayList<>();
        final ArrayList<Cat> cats = new ArrayList<>();
        final ArrayList<XiaoHuaMao> xiaoHuaMaos = new ArrayList<>();
        final ArrayList<Car> cars = new ArrayList<>();


        genericStudy.method2(dogs);
        genericStudy.method2(cats);
        genericStudy.method2(haShiQis);
        genericStudy.method2(xiaoHuaMaos);
        genericStudy.method2(cars);

        genericStudy.method3(dogs);
        genericStudy.method3(cats);
        genericStudy.method3(haShiQis);
        genericStudy.method3(xiaoHuaMaos);
        genericStudy.method3(cars);

    }
}
