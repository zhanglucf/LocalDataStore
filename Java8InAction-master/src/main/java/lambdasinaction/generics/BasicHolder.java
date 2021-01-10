package lambdasinaction.generics;


public class BasicHolder<T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

     void f(){
         System.out.println("t:"+ t.getClass().getSimpleName());
     }
}
/**
 *古怪的循环泛型(CRG) :类出现在它自己基类中
 *  它能够产生使用导出类作为其参数和返回类型的基类
 */
class Subtype extends BasicHolder<Subtype>{}

class Other{}
class AA extends BasicHolder<Other>{}


class Test{
    public static void main(String[] args) {
//        Subtype sub = new Subtype();
//        System.out.println(new Subtype());
//        sub.setT(sub);
//        final Subtype t = sub.getT();
//        System.out.println(t);
//        sub.f();
        final AA a = new AA();
        a.setT(new Other());
        System.out.println(a.getT());
        a.f();
        System.exit(0);
    }
}