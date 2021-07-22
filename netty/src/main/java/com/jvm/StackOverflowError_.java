package com.jvm;

/**
 * @author zzh
 * @date 2021年07月21日
 */
public class StackOverflowError_ {
    public static void main(String[] args) {
        try {
            method();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void method() {
        System.out.println("---");
        method();
    }
}
