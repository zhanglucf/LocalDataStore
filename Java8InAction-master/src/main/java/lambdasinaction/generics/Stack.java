package lambdasinaction.generics;

import java.io.Serializable;
import java.util.*;

public class Stack<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        E e = (E) elements[--size];
        elements[size] = null;
        return e;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    //PECS
    public void pushAll(Iterable<? extends E> iterable) {
        for (E e : iterable) {
            push(e);
        }
    }

    //弹出所有
    public void popAll(Collection<? super E> dest) {
        while (isEmpty())
            dest.add(pop());
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 + size + 1);
        }
    }
}

class TestStack {
    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        List<Integer> integers = Arrays.asList(2, 3, 4);
        List<Number> numbers = Arrays.asList(2, 3, 4);

        stack.pushAll(integers);
        stack.pushAll(numbers);

        final List<Serializable> numbers1 = new ArrayList<>();
//        final List<Integer> numbers1 = new ArrayList<>();
        stack.popAll(numbers1);

    }
}