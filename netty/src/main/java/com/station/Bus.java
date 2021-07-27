package com.station;

import java.util.concurrent.atomic.AtomicInteger;

public class Bus {
    private int busId;
    private int stationId;

    public Bus(int busId, int stationId) {
        this.busId = busId;
        this.stationId = stationId;
    }

    private int PASSENGER_COUNT_MAX = 29;
    //表示每个站台等候的乘客的人数
    private AtomicInteger passengerCounter = new AtomicInteger(0);

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }


    public AtomicInteger getPassengerCounter() {
        return passengerCounter;
    }

    public void setPassengerCounter(AtomicInteger passengerCounter) {
        this.passengerCounter = passengerCounter;
    }

    //乘客上车
    public void getOnTheBus(int passengerCount) {
        ThreadUtil.sleepSeconds(passengerCount);
    }

    //乘客上车
    public void getOnTheBus(Station station) {
        if (station.passengerCounter.get() > 0) {
            //站台人太多，拉不下，那就拉满就走
            if (station.passengerCounter.get() + this.passengerCounter.get() > PASSENGER_COUNT_MAX) {
                int canTakeMax = PASSENGER_COUNT_MAX - this.passengerCounter.get();
                getOnTheBus(canTakeMax);
                System.out.println("上车" + canTakeMax + "人");
                this.passengerCounter.addAndGet(canTakeMax);

            } else {
                //站台人全部拉走
                getOnTheBus(station.passengerCounter.get());
                System.out.println("上车" + station.passengerCounter.get() + "人");
                this.passengerCounter.addAndGet(station.passengerCounter.get());
            }
        }
    }

    //乘客下车
    public synchronized void getOffTheBus(int passengerCount) {
        if (passengerCount > 0) {
            ThreadUtil.sleepSeconds(passengerCount);
            for (int i = 0; i < passengerCount; i++) {
                this.getPassengerCounter().decrementAndGet();
                System.out.println("下车1人");
            }
        }
    }

    public void run(){
        while (true){
            for (int i = 1; i <= 28; i++) {
                final int passengerCountOfThisBuss = this.getPassengerCounter().get();
                final int passengergetOffTheBusCountOfThisBuss = CommandCenter.random.nextInt(passengerCountOfThisBuss + 1);
                this.getOffTheBus(passengergetOffTheBusCountOfThisBuss);
                this.setStationId(i);
                this.getOnTheBus(CommandCenter.Map.get(i));
                System.out.println(this);
            }
        }
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                "Bus上" + getPassengerCounter() +
                "人, stationId=" + CommandCenter.Map.get(stationId) +
                '}';
    }
}
