package lambdasinaction.generics;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

interface Skill{
    void play();
}

class Supp implements Comparable<Supp> {

    @Override
    public int compareTo(Supp o) {
        return 0;
    }
}
class Subb extends Supp{}


class Animal{
    int speed;
    String name;
}

class Dog extends Animal implements Comparable<Animal>{
    @Override
    public int compareTo(Animal o) {
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

    public <T extends Comparable<? super T>,U extends T> void method3(T t,U u) {}
    public <T extends Comparable<? super T>> void method4(BiConsumer<T,? extends T> consumer) {}
    public <T extends Comparable<? super T>> void method5(BiConsumer<T,T> consumer) {}
    public void method6(Animal[] animalArray){}
    public void method7(List<Animal> animalList){}
    public static void main(String[] args) {
        final GenericStudy genericStudy = new GenericStudy();


        genericStudy.method3(new Dog(),new Dog());
        genericStudy.method3(new HaShiQi(),new Dog());
        genericStudy.method6(new Animal[]{});
        genericStudy.method6(new Dog[]{});
        genericStudy.method7(new ArrayList<Animal>());
//        genericStudy.method7(new ArrayList<Dog>());
        ArrayList<String> aa = new ArrayList<String>() {
            {
//                add("aa");
                System.out.println();
            }
        };
        System.out.println(aa);
        genericStudy.method4((Dog x,HaShiQi h)->{});
        genericStudy.method4((Dog x,Dog h)->{});
//
//        genericStudy.method5((Dog x,HaShiQi h)->{});
        genericStudy.method5((Dog x,Dog h)->{});

    }
}
