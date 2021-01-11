package lambdasinaction.chap6;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import static java.util.stream.Collector.Characteristics.*;

//定义自己的收集器
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    /**
     * 定义结果容器
     * @return
     */
    @Override
    public Supplier<List<T>> supplier() {
        return () -> new ArrayList<T>();
    }

    /**
     * 定义累加器
     * @return
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (list, item) -> list.add(item);
    }

    /**
     * 对容器结果做最后的类型转换
     * @return
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return i -> i;
    }

    /**
     * 结果合并，并行的时候才会用到
     * @return
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
    }
}
