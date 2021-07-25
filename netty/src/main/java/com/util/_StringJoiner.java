package com.util;

import org.apache.commons.lang3.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class _StringJoiner {

    public static void main(String[] args) {
        Validate.exclusiveBetween(1, 3, 2, "超出范围");
        String text = "";
        Validate.notNull(text, "%s 不能为空", "text");
        Validate.notBlank("a", "%s 不能为空", "text");
        final ArrayList<String> list = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
                add("d");
                add("e");
                add("f");

            }
        };
        System.out.println(list.stream().collect(Collectors.joining(",", "[", "]")));
        System.out.println(list.stream().collect(Collectors.joining("\", \"", "[\"", "\"]")));
        System.out.println(list.stream().collect(Collectors.joining("\', \'", "[\'", "\']")));

        final List<A> aList = new ArrayList<A>() {
            {
                add(new A(1,3));
                add(new A(2,6));
                add(new A(3,9));
                add(new A(4,3));
                add(new A(5,1));
                add(new A(6,3));
            }
        };
        aList.forEach(System.out::println);
        final StringJoiner joiner = new StringJoiner(",","[","]");
        System.out.println(joiner);
        joiner.setEmptyValue("");
        System.out.println(joiner);
        joiner.add("张三");
        joiner.add("卡卡罗特");
        System.out.println(joiner);
    }

    public static String leftSubPath(String path, int index) {
        return method(path).get(index);
    }

    private static List<String> method(String path) {
        final StringJoiner joiner = new StringJoiner("/", "/", "");
        return Arrays.stream(path.split("/"))
                .filter(StringUtils::isNotBlank)
                .map(x -> joiner.add(x).toString())
                .collect(Collectors.toList());
    }
}
