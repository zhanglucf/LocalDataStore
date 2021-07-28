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
        this.passengerCounter.addAndGet(passengerCount);
    }

    //乘客上车
    public void getOnTheBus(Station station) {
        if (station.passengerCounter.get() > 0) {
            //站台人太多，拉不下，那就拉满就走
            if (station.passengerCounter.get() + this.passengerCounter.get() > PASSENGER_COUNT_MAX) {
                int canTakeMax = PASSENGER_COUNT_MAX - this.passengerCounter.get();
                getOnTheBus(canTakeMax);
                System.out.print("上客" + canTakeMax + "人 ");
                station.decrementAndGet(canTakeMax);
            } else {
                //站台人全部拉走
                getOnTheBus(station.passengerCounter.get());
                System.out.print("上客" + station.passengerCounter.get() + "人 ");
                station.decrementAndGet(station.passengerCounter.get());
            }
        }
    }

    //乘客下车
    public synchronized void getOffTheBus(int passengerCount) {
        if (passengerCount > 0) {
            ThreadUtil.sleepSeconds(passengerCount);
            for (int i = 0; i < passengerCount; i++) {
                this.getPassengerCounter().decrementAndGet();
            }
            System.out.print("下客" + passengerCount + "人 ");
        }
    }

    //模拟Bus从一站 到 下一站
    public synchronized void stationToStaion(Station station) {
        System.out.println(TimeUtil.getCurrentTimeStr() + " 继续出发 车上有乘客" + this.passengerCounter + "人");
//            System.out.print(this);
        int i = ((station.getNextStationId() > 15) ? (30 - station.getNextStationId()) : +station.getNextStationId());
        String stationNum = String.format("%02d", i);
        ThreadUtil.sleepSeconds(station.getNextStationIdTimeDuration());
        System.out.println(TimeUtil.getCurrentTimeStr() + " 到达" + stationNum + "站");
    }

    public void getOffAll(Station station) {
        if ((station.getStationId() == 15 && station.getNextStationId() == 16)
                || (station.getStationId() == 28 && station.getNextStationId() == 1)) {
            int i = this.getPassengerCounter().get();
            getOffTheBus(i);
            //下车的乘客 还需要继续乘车
            station.addAndGet(i);
            System.out.println("到达终点，所有乘客下车");
        }
    }

    public void run() {
        boolean flag = true;
        while (true) {
            for (int i = this.stationId; i <= this.stationId + 27; i++) {
                if (flag && i == 1) {
                    flag = false;
                    System.out.println("从01站台出发");
                }else if (flag && i == 15){
                    flag = false;
                    System.out.println("从15站台出发");
                }
                final int passengerCountOfThisBuss = this.getPassengerCounter().get();
                final int passengergetOffTheBusCountOfThisBuss = CommandCenter.random.nextInt(passengerCountOfThisBuss + 1);
                getOffAll(CommandCenter.Map.get(i));
                this.getOffTheBus(passengergetOffTheBusCountOfThisBuss);
                this.setStationId(i);
                this.getOnTheBus(CommandCenter.Map.get(i));
//                System.out.print(this);
                stationToStaion(CommandCenter.Map.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return " 车上有" + getPassengerCounter() + "人";
    }
}
