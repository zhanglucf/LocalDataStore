package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Apples {
    public static List<Sorting.Apple> inventory = new ArrayList<>();
   static {
        inventory
                .addAll(Arrays.asList(new Sorting.Apple(80,"green"),
                new Sorting.Apple(155, "green"),
                new Sorting.Apple(120, "red"),
                new Sorting.Apple(120, "zc"),
                new Sorting.Apple(120, "zb"),
                new Sorting.Apple(120, "za"),
                new Sorting.Apple(120, "red")));
   }

}
