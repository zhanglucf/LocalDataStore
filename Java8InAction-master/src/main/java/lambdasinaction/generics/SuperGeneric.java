package lambdasinaction.generics;

public class SuperGeneric<T extends SuperGeneric<? super T>> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class SubGen extends SuperGeneric<SubGen>{}

class SubGen2 extends SuperGeneric<SubGen>{

}