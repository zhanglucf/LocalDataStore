package lambdasinaction.chap6;


import lambdasinaction.chap3.Apples;
import lambdasinaction.chap3.Sorting;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.stream.Collector.Characteristics.CONCURRENT;

public class Collector_ {
    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("hello", "world", "java");
        BiConsumer<ArrayList, String> biConsumer = (m, n) -> m.add(n);
        BiFunction<ArrayList, String, Boolean> biFunction = (m, n) -> m.add(n);

        final CustomizeList<String> collect = strings.parallelStream()
//                .collect(() -> new CustomizeList(), (m, n) -> m.add(n), (m1, m2) -> m1.addAl(m2));
                .collect(CustomizeList<String>::new, CustomizeList::add, CustomizeList::addAll);
//        System.out.println(collect);
        final ArrayList<String> of = strings.stream()
                .collect(java.util.stream.Collector.of(
                        ArrayList::new,
                        ArrayList::add,
                        (left, right) -> {
                            left.addAll(right);
                            return left;
                        },
                        CONCURRENT
                ));
//        System.out.println(of);

        //版本一
        strings.stream()
                .collect(StringBuffer::new,
                        StringBuffer::append,
                        StringBuffer::append);

        //版本二，使用finisher对Reduce结果做最终的转换
        strings.stream()
                .collect(java.util.stream.Collector.of(StringBuffer::new,
                        StringBuffer::append,
                        (l, r) -> l.append(r),
                        StringBuffer::toString,
                        CONCURRENT));

        //版本一 使用JDK自带的工具类 Collectors
        strings.stream().collect(Collectors.joining());


        //版本一
        String str3 = strings.stream()
                .collect(java.util.stream.Collector.of(StringBuffer::new,
                        (buf, s) -> buf.append(s).append(","),
                        (l, r) -> l.append(r),
                        b -> {
                            int length = b.toString().length();
                            return b.toString().substring(0, length - 1);
                        },
                        CONCURRENT));

        //版本一
        strings.stream()
                .collect(java.util.stream.Collector.of(
                        () -> new StringJoiner(",", "", ""),
                        (StringJoiner l, String r) -> l.add(r),
                        (StringJoiner l, StringJoiner r) -> l.merge(r),
                        StringJoiner::toString,
                        CONCURRENT));


        //版本二 用方法引用改进，简化书写形式
        strings.stream()
                .collect(java.util.stream.Collector.of(
                        () -> new StringJoiner(",", "", ""),
                        StringJoiner::add,
                        StringJoiner::merge,
                        StringJoiner::toString,
                        CONCURRENT));


        //版本三 使用JDK自带的工具类 Collectors
        strings.stream().collect(Collectors.joining(","));


        //版本一
        strings.stream()
                .collect(java.util.stream.Collector.of(
                        () -> new StringJoiner(",", "[", "]"),
                        StringJoiner::add,
                        StringJoiner::merge,
                        StringJoiner::toString,
                        CONCURRENT));

        //版本二 使用JDK自带的工具类 Collectors
        strings.stream()
                .collect(Collectors.joining(",", "[", "]"));

        /*
        public static <T> Collector_<T, ?, Optional<T>> reducing(BinaryOperator<T> op)
         */
        strings.stream().collect(Collectors.reducing((s1, s2) -> s1.concat(s2)));


        //一个类的静态方法 被用来作方法引用 则方法的签名不变
        Consumer<Boolean> consumer = String::valueOf;

        //一个类A的非静态方法 被用来作方法引用 则方法引用的参数增加一位，类型为A,而且位置在最左边
        BiFunction<String, String, String> bf = String::concat;

        //BiConsumer和BiFunction如果是用方法引用的形式表示的，则他们可以指向同一个方法,例如bf和bc都指向String#concat
        BiConsumer<String, String> bc = String::concat;

/*
        public static <T> Collector_<T, ?, Optional<T>> reducing(BinaryOperator<T> op)
 */
        strings.stream().collect(Collectors.reducing(String::concat));
/*
        public static <T> Collector_<T, ?, T> reducing(T identity,
         BinaryOperator<T> op)
 */
        strings.stream().collect(Collectors.reducing("start", String::concat));
/*
         public static <T, U> Collector_<T, ?, U> reducing(U identity,
                                Function<? super T, ? extends U> mapper,
                                BinaryOperator<U> op)
*/
        Apples.inventory.stream().collect(Collectors.reducing("", Sorting.Apple::getColor, String::concat));

/*
        public static <T, K> Collector_<T, ?, Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier)

        这个也是解释“一个类A的非静态方法 被用来作方法引用 则方法引用的参数增加一位，类型为A,而且位置在最左边”的一个栗子
        Function<Sorting.Apple,Integer> function = Sorting.Apple::getWeight;
*/
        Map<Integer, List<Sorting.Apple>> groupByWeight =
                Apples.inventory.stream().collect(Collectors.groupingBy(Sorting.Apple::getWeight));

        Map<String, List<Sorting.Apple>> groupByColor =
                Apples.inventory.stream().collect(Collectors.groupingBy(Sorting.Apple::getColor));

        /*
        public static <T, K, A, D>
        Collector_<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
                                          Collector_<? super T, A, D> downstream)
         */
        Map<String, List<Sorting.Apple>> groupingBy =
                Apples.inventory.stream().collect(Collectors.groupingBy(Sorting.Apple::getColor,
                        Collectors.toList()));
//        System.out.println(groupingBy);

        Map<String, List<Integer>> groupingBy2 =
                Apples.inventory.stream().collect(Collectors.groupingBy(Sorting.Apple::getColor,
                        Collectors.mapping(Sorting.Apple::getWeight, Collectors.toList())));
//        System.out.println(groupingBy2);


        Map<String, Long> groupingBy3 =
                Apples.inventory.stream().collect(Collectors.groupingBy(Sorting.Apple::getColor,
                        Collectors.counting()));
//        System.out.println(groupingBy3);

        Map<String, Map<Integer, List<Sorting.Apple>>> groupingBy4 =
                Apples.inventory.stream().collect(Collectors.groupingBy(Sorting.Apple::getColor,
                        Collectors.groupingBy(Sorting.Apple::getWeight, Collectors.toList())));
//        System.out.println(groupingBy4);


//        二级分组，自定义key
        Map<String, Map<String, List<Sorting.Apple>>> groupingBy5 =
                Apples.inventory.stream()
                        .collect(Collectors.groupingBy(Sorting.Apple::getColor,
                                Collectors.groupingBy(apple -> {
                                    if (apple.getWeight() < 100) return "小果子";
                                    if (apple.getWeight() < 150) return "中型果";
                                    return "大型果";
                                }, Collectors.toList())));
        System.out.println(groupingBy5);


        Apples.inventory.stream()
                .collect(Collectors.groupingBy(Sorting.Apple::getColor,
                        Collectors.maxBy((a, b) -> {
                            return a.getWeight() > b.getWeight() ? 1 :
                                    a.getWeight() == b.getWeight() ? 0 : -1;
                        })));

        Apples.inventory.stream()
                .collect(Collectors.groupingBy(Sorting.Apple::getColor,
                        Collectors.maxBy((a, b) -> a.getWeight() > b.getWeight() ? 1 :
                                a.getWeight() == b.getWeight() ? 0 : -1)));

        //按照颜色分组，找出每种颜色里重量最大的苹果
        Map<String, Optional<Sorting.Apple>> groupingBy6 = Apples.inventory.stream()
                .collect(Collectors.groupingBy(Sorting.Apple::getColor,
                        Collectors.maxBy(Comparator.comparingInt(Sorting.Apple::getWeight))));
        System.out.println(groupingBy6);


        Apples.inventory.stream()
                .collect(Collectors.groupingBy(Sorting.Apple::getColor,
                        Collectors.mapping(Sorting.Apple::getWeight,
                                Collectors.maxBy((o1, o2) -> o1.compareTo(o2)))));


        //按照颜色分组，找出每种颜色里最大的苹果重量
        Map<String, Optional<Integer>> var =
                Apples.inventory.stream()
                        .collect(Collectors.groupingBy(Sorting.Apple::getColor,
                                Collectors.mapping(Sorting.Apple::getWeight,
                                        Collectors.maxBy(Integer::compareTo))));

        //上面的Optional貌似多余的，可以像下面这样改进
        Map<String, Sorting.Apple> var2 = Apples.inventory.stream()
                .collect(Collectors.groupingBy(Sorting.Apple::getColor,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Sorting.Apple::getWeight)),
                                Optional::get)));

        //如果只想知道每种颜色最大重量，而不需要得到具体最重的苹果，可以进行如下改进
        Map<String, Integer> var4 = Apples.inventory.stream()
                .collect(Collectors.groupingBy(Sorting.Apple::getColor,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Sorting.Apple::getWeight)),
                                x -> x.get().getWeight())));
        //或者
        Map<String, Integer> var3 = Apples.inventory.stream()
                .collect(Collectors.groupingBy(Sorting.Apple::getColor,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Sorting.Apple::getWeight,
                                        Collectors.maxBy(Integer::compare)),
                                Optional::get)));
//
        List<String> list = new ArrayList<String>() {{
            add("aaa");
            add("bbb");
        }};
    }


}
/*

 */