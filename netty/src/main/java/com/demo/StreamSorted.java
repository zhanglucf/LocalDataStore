package com.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamSorted {
    public static void main(String[] args) {
        final LocalDateTime now = LocalDateTime.now();
        List stuList =  new ArrayList<Stu>(){
            {
                add(new Stu(1,2,now));
                add(new Stu(1,3,now.minusDays(1)));
                add(new Stu(1,5,now.minusDays(2)));
                add(new Stu(4,6,now.minusDays(1)));
                add(new Stu(5,7,now.minusDays(6)));
                add(new Stu(6,8,now.minusDays(1)));
            }
        };

        stuList.stream()
                .sorted(Comparator.comparingInt(Stu::getId).reversed()
                        .thenComparingInt(Stu::getScore).reversed())
                .forEach(System.out::println);
        stuList.stream().sorted(Comparator.comparing(Stu::getDate)).forEach(System.out::println);
    }
}
