package lambdasinaction.chap1;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 需求：
 * 使用行为参数化，编写一个灵活的打印苹果信息的方法。
 * 要求：
 * 1. 可以只打印苹果重量
 * 2. 可以在打印苹果重量的同时，打印出这个平多是重的还是轻的
 */
public class PrettyPrint {

    static List<Apple> apples = Arrays.asList(new Apple(80, "green"),
            new Apple(155, "green"),
            new Apple(120, "red"));

    public static <T> void prettyPrint(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {
        Consumer<Apple> printOnly = System.out::println;

        Consumer<Apple> print = apple -> {
            String desc = apple.getWeight() < 100 ? "小型果"
                    : apple.getWeight() < 150 ? "中型果" : "大型果";
            System.out.format("%s -> %s%n", apple, desc);
        };

        prettyPrint(apples, printOnly);
        System.out.println("---------------");
        prettyPrint(apples, print);
    }
}
