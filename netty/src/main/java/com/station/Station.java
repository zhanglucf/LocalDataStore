package com.station;

import java.util.concurrent.atomic.AtomicInteger;

public class Station {
    private int stationId;
    private int nextStationId;
    private int nextStationIdTimeDuration;
    //表示每个站台等候的乘客的人数
    public AtomicInteger passengerCounter = new AtomicInteger(0);

    public Station(int stationId, int nextStationId, int nextStationIdTimeDuration) {
        this.stationId = stationId;
        this.nextStationId = nextStationId;
        this.nextStationIdTimeDuration = nextStationIdTimeDuration;
    }

    //给站台加人
    public int addAndGet(int addCount) {
        return passengerCounter.addAndGet(addCount);
    }

    public int decrementAndGet(int addCount) {
        int counter = 0;
        synchronized (this) {
            for (int i = 0; i < addCount; i++) {
                counter = passengerCounter.decrementAndGet();
            }
        }
        return counter;
    }

    //获取站台所有乘客
    public int removeAll() {
        int counter = 0;
        synchronized (this) {
            counter = passengerCounter.get();
            for (int i = 0; i < counter; i++) {
                passengerCounter.decrementAndGet();
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        if (stationId > 15) {
            return "这是" + (stationId % 15) + "号站台  下一站是" + (nextStationId % 15) + "号站台";
        } else {
            return "这是" + stationId + "号站台 下一站是" + (nextStationId>15? (nextStationId % 15):nextStationId) + "号站台";
        }
    }

    public static void main(String[] args) {
        System.out.println(16%15);
    }
}
