package com.util;

import java.util.StringJoiner;

public class A {
    private int x;
    private int y;

    public A(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "A = " +  new StringJoiner(",", "[", "]")
                .add("x=" + this.x)
                .add("y=" + this.y)
                .toString();
    }
}
