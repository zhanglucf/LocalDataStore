package lambdasinaction.generics;

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends SelfBounded<A>{}

public class SelfBounding {

    public static <T extends SelfBounded<T>> T method(T t) {
        return t.get();
    }

    public static void main(String[] args) {
        SelfBounding.method(new SelfBounded());
        A ret = SelfBounding.method(new A());
    }
}

