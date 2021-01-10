package lambdasinaction.chap5;

import lambdasinaction.chap3.Apples;
import lambdasinaction.chap3.Sorting;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Reduce {
    public static void main(String[] args) {
        final List<Sorting.Apple> apples = Apples.inventory;
        final Optional<Sorting.Apple> optionalApple = apples.stream()
//                .reduce((x, y) -> x.getWeight() <= y.getWeight() ? y : x);
                .reduce((x, y) -> x.getWeight() <= y.getWeight() ? y : x);
        System.out.println("最大的苹果："+ optionalApple.orElseGet(null));

        final OptionalInt sumOptional =
                IntStream.rangeClosed(0, 10)
                .reduce(Integer::sum);
        System.out.println("sumOptional = " + sumOptional);

        final long max = LongStream.rangeClosed(0, 10)
                .reduce(Long::max).orElse(0);
        System.out.println("max = " + max);
    }
}
