package com.jvm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author zzh
 * @date 2021年07月21日
 */
public class OOM_GCOverHeadLimitExceeded {

    /**
     * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
     */
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(i + UUID.randomUUID().toString()).intern());
            }
        } catch (Exception e) {
            System.out.println(i);
            e.printStackTrace();
        }
    }



}
