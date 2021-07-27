package com.station;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class CommandCenter {
    final static Random random = new Random();
    final static Map<Integer, Station> Map = new ConcurrentHashMap<Integer, Station>() {
        {
            put(1, new Station(1, 2, random.nextInt(6) + 3));
            put(2, new Station(2, 3, random.nextInt(6) + 3));
            put(3, new Station(3, 4, random.nextInt(6) + 3));
            put(4, new Station(4, 5, random.nextInt(6) + 3));
            put(5, new Station(5, 6, random.nextInt(6) + 3));
            put(6, new Station(6, 7, random.nextInt(6) + 3));
            put(7, new Station(7, 8, random.nextInt(6) + 3));
            put(8, new Station(8, 9, random.nextInt(6) + 3));
            put(9, new Station(9, 10, random.nextInt(6) + 3));
            put(10, new Station(10, 11, random.nextInt(6) + 3));
            put(11, new Station(11, 12, random.nextInt(6) + 3));
            put(12, new Station(12, 13, random.nextInt(6) + 3));
            put(13, new Station(13, 14, random.nextInt(6) + 3));
            put(14, new Station(14, 15, random.nextInt(6) + 3));
            put(15, new Station(15, 16, random.nextInt(6) + 3));
            put(16, new Station(16, 17, random.nextInt(6) + 3));
            put(17, new Station(17, 18, random.nextInt(6) + 3));
            put(18, new Station(18, 18, random.nextInt(6) + 3));
            put(19, new Station(19, 20, random.nextInt(6) + 3));
            put(20, new Station(20, 21, random.nextInt(6) + 3));
            put(21, new Station(21, 22, random.nextInt(6) + 3));
            put(22, new Station(22, 23, random.nextInt(6) + 3));
            put(23, new Station(23, 24, random.nextInt(6) + 3));
            put(24, new Station(24, 25, random.nextInt(6) + 3));
            put(25, new Station(25, 26, random.nextInt(6) + 3));
            put(26, new Station(26, 27, random.nextInt(6) + 3));
            put(27, new Station(27, 28, random.nextInt(6) + 3));
            put(28, new Station(28, 1, random.nextInt(6) + 3));
        }
    };

    public void method() {

        new Thread(() -> {
            while (true) {
                ThreadUtil.sleepSeconds(1);
                Map.get(random.nextInt(28) + 1).addAndGet(1);
            }
        }).start();

        final List<Bus> buses = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
           new Thread( new Bus(i , 1)::run).start();
        }
    }

    public static void main(String[] args) {
       new CommandCenter().method();
    }
}
