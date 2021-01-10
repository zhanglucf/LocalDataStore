package lambdasinaction.chap6;

import java.util.ArrayList;
import java.util.Collection;

public class CustomizeList<E> extends ArrayList<E> {

    public CustomizeList() {
        super();
        System.out.println(Thread.currentThread().getName() + "constructor");
    }

    public boolean ad(E e) {
        System.out.println(Thread.currentThread().getName() + "add");
        return super.add(e);
    }

    public boolean addAl(Collection<? extends E> c) {
        System.out.println(Thread.currentThread().getName() + "### addAll");
        return super.addAll(c);
    }
}
