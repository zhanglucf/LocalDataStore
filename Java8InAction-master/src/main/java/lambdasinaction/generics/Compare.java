package lambdasinaction.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface Compare<T> {
    int compareTo(T t);
}

class Parent implements Compare<Parent>{
    @Override
    public int compareTo(Parent aaa) {
        return 0;
    }
}

class Sub extends Parent {}

class Parent2 implements Compare<Parent2 >{
    @Override
    public int compareTo(Parent2 bbb) {
        return 0;
    }
}

class Sub2 extends Parent2 {}

class Sub22 extends Sub2 {}



//
class CompareTest {
    //类自身实现了ComPare接口或者其基类实现了Compare接口
    public static <T extends Compare<? super T>> int method(T t, T t2) {
        return t.compareTo(t2);
    }

    public static <T extends Compare<? super T>> int method4(List<? super T> list, T t2) {
//        类型丢失
        for (Object t : list) {
//            t.compareTo(t2);  编译报错
        }
        return 0;
    }


    public static <T extends Compare<? super T>> int method5(List<T> list, T t2) {

        CompareTest.method5(new ArrayList<Parent>(),new Parent());
        CompareTest.method5(new ArrayList<Parent>(),new Sub());//多态
        CompareTest.method5(new ArrayList<Sub>(),new Sub());
//        CompareTest.method5(new ArrayList<Sub>(),new Parent());编译报错

        for (T t : list) {
            t.compareTo(t2);
        }
        return 0;
    }

    public static <T extends Compare<? super T>> int method6(List<? extends T> list, T t2) {
//        list很灵活，又不会丢失类型（T）
        CompareTest.method6(new ArrayList<Parent>(),new Parent());
        CompareTest.method6(new ArrayList<Parent>(),new Sub());
        CompareTest.method6(new ArrayList<Sub>(),new Sub());
        CompareTest.method6(new ArrayList<Sub>(),new Parent());

        for (T t : list) {
            t.compareTo(t2);
        }
        return 0;
    }

    public static <T,U extends Compare<? super U>> Compare<T> method7(Function<T,? extends U> function) {
        Function<Integer,Parent> p1 = (x)-> new Parent();
        Function<Integer,Sub> p2 = (x)-> new Sub();
        Function<Integer,Parent> p3 = (x)-> new Sub();
        Function<Integer,Sub2> p4 = (x)-> new Sub22();
        method7(p1);
        method7(p2);
        method7(p3);
        method7(p4);

        return (T m) -> {
            U apply = function.apply(m);
            return  function.apply(m).compareTo(function.apply(m));
        };

    }

    //Compare类型参数只能是自身
    public static <T extends Compare<T>> int method2(T t, T t2) {
        return t.compareTo(t2);
    }

    //Compare类型参数可以是自身或者导出类
    public static <T extends Compare<? extends T>> int method3(T t, T t2) {
        return 0;
    }

    public static void main(String[] args) {
        final Parent parent = new Parent();
        final Sub sub = new Sub();

//        CompareTest.method(parent, parent);
//        CompareTest.method(sub, sub);
//
//        CompareTest.method2(parent, parent);
//        CompareTest.method2(sub, sub);
//
//        final Parent2 p = new Parent2();
//        final Sub2 sub2 = new Sub2();
//
//
//        CompareTest.method2(parent, parent);
//        CompareTest.method2(sub2, sub2);
//
//        CompareTest.method3(parent, parent);
//        CompareTest.method3(sub2, sub2);
//
//        CompareTest.method4(new ArrayList<Parent>(),parent);
//        CompareTest.method4(new ArrayList<Parent>(),new Sub());
//        CompareTest.method4(new ArrayList<Sub>(),new Sub());
//        CompareTest.method4(new ArrayList<Sub>(),new Parent());
    }
}