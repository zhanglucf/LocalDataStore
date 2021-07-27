package com.station;

import java.util.concurrent.TimeUnit;

public class ThreadUtil {

    public static void sleepSeconds(long timeout){
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepMicroseconds(long timeout){
        try {
            TimeUnit.MICROSECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
