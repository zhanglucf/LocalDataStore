package lambdasinaction.generics;

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



//
class CompareTest {
    //类自身实现了ComPare接口或者其基类实现了Compare接口
    public static <T extends Compare<? super T>> int method(T t, T t2) {
        return t.compareTo(t2);
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

        CompareTest.method(parent, parent);
        CompareTest.method(sub, sub);

        CompareTest.method2(parent, parent);
        CompareTest.method2(sub, sub);

        final Parent2 p = new Parent2();
        final Sub2 sub2 = new Sub2();


        CompareTest.method2(parent, parent);
        CompareTest.method2(sub2, sub2);

        CompareTest.method3(parent, parent);
        CompareTest.method3(sub2, sub2);
    }
}