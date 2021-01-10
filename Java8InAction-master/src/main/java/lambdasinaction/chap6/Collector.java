package lambdasinaction.chap6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collector.Characteristics.CONCURRENT;

public class Collector {
    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("hello", "world", "java");
        BiConsumer<ArrayList, String> biConsumer = (m, n) -> m.add(n);
        BiFunction<ArrayList, String, Boolean> biFunction = (m, n) -> m.add(n);

        final CustomizeList<String> collect = strings.parallelStream()
//                .collect(() -> new CustomizeList(), (m, n) -> m.add(n), (m1, m2) -> m1.addAl(m2));
                .collect(CustomizeList<String>::new, CustomizeList::add,CustomizeList::addAll);
        System.out.println(collect);

        final ArrayList<String> of = strings.stream()
                .collect(java.util.stream.Collector.of((Supplier<ArrayList<String>>) ArrayList::new,
                        ArrayList::add,
                        (left, right) -> {
                            left.addAll(right);
                            return left;
                        },
                        CONCURRENT
                ));
        System.out.println(of);
    }

}
