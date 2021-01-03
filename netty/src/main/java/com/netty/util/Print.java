package com.netty.util;

public class Print {

    public static void println(Object val){
        System.out.format("%s%n", val);
    }
    public static void println(String str,Object val){
        System.out.format("%s : %s%n", str, val);
    }

    public static void printlnTN(Object val){
        System.out.format("%s : %s%n",Thread.currentThread().getName(), val);
    }
    public static void printlnTN(String str,Object val){
        System.out.format("%s %s : %s%n",Thread.currentThread().getName() ,str, val);
    }

    public static void eprintln(Object val){
        System.err.format("%s%n", val);
    }
    public static void eprintln(String str,Object val){
        System.err.format("%s : %s%n", str, val);
    }

    public static void eprintlnTN(Object val){
        System.err.format("%s : %s%n",Thread.currentThread().getName(), val);
    }
    public static void eprintlnTN(String str,Object val){
        System.err.format("%s %s : %s%n",Thread.currentThread().getName() ,str, val);
    }
}
