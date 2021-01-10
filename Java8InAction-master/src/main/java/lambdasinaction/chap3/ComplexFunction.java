package lambdasinaction.chap3;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ComplexFunction {

    public static void main(String[] args) {
        final ComplexFunction reversed = new ComplexFunction();
        //reversed.method();
//        reversed.method2();
        reversed.method3();
    }

    //比较器复合
    public void method() {
        final List<Sorting.Apple> inventory = Apples.inventory;
        System.out.println(inventory);
        //按照重量升序
        inventory.sort(Comparator.comparing(Sorting.Apple::getWeight));
        System.out.println(inventory);
        //按照重量降序
        inventory.sort(Comparator.comparing(Sorting.Apple::getWeight).reversed());
        System.out.println(inventory);
        inventory.sort(Comparator
                .comparing(Sorting.Apple::getWeight)
                .reversed()
                .thenComparing(Sorting.Apple::getColor));
        System.out.println(inventory);
    }

    //谓语复合
    public void method2() {
        Predicate<Sorting.Apple> predicate = apple -> "green".equals(apple.getColor());
        final Predicate<Sorting.Apple> complexPredicate =
                //非
                predicate.negate()
                        .and(apple -> 150 > apple.getWeight())
                        .or(predicate);

        final List<Sorting.Apple> inventory = Apples.inventory;
        inventory.stream().filter(complexPredicate).forEach(System.out::println);
    }

    public void method3() {
        //复合函数
        Function<Integer, Integer> f = (x) -> x + 1;
        Function<Integer, Integer> g = (x) -> x * 2;
        //g(f(x))
        final Function<Integer, Integer> andThen = f.andThen(g);
        System.out.println(andThen.apply(3));
        //f(g(x))
        final Function<Integer, Integer> compose = f.compose(g);
        System.out.println(compose.apply(3));

        //复合函数的应用场景
        Function<String,String> addHeader = x -> "<<中国汽车销量排行榜>>\r\n".concat(x);
        Function<String,String> addFoot = x -> x.concat("\r\n  2021-01-10");
        final String complete = addHeader.andThen(addFoot).apply("第一名：轩逸\r\n第二名：朗逸\r\n第三名：卡罗拉\r\n");
        System.out.println(complete);
    }
}
