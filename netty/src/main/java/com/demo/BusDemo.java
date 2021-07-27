package com.demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class BusDemo {
    public static final Random random = new Random();
    public static int[] lToRSiteArray = {5, 6, 7, 8, 4, 3, 6, 5, 6, 7, 4, 3, 6, 8};
    public static int[] rToLSiteArray = {4, 7, 5, 6, 3, 4, 5, 3, 7, 4, 5, 4, 5, 4};
    public static final int[] wuCha = {-1, 0, 1};
    //模拟整个过程中乘客的数量
    public static final AtomicLong atomicLong = new AtomicLong(0);
    public static final int siteTotal = 15;

    public static void main(String[] args) {
    }

    public static final LocalDateTime start = LocalDateTime.now();


}


class Bus {
    //车上乘客的数量
    public Integer cks = 0;
    public Integer siteNum = null;
    public Boolean lToR = null;

    public Bus(Integer cks, Integer siteNum, Boolean lToR) {
        this.cks = cks;
        this.siteNum = siteNum;
        this.lToR = lToR;
    }


    //模拟每5分钟 有十名乘客
    public synchronized long getCK() {
        Long ckCount = null;
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        final long limit = getLimit();
        if (atomicLong.get() > limit) {
            return 0;
        } else {
            //模拟随机出现的乘客数量
            ckCount = Long.valueOf(random.nextInt(6));
            if (((this.cks + ckCount) > 29)) {
                ckCount = 29L - this.cks;
            }
            atomicLong.set(ckCount + atomicLong.get());
        }
        return ckCount;
    }


    public static long getLimit() {
        long duration = Duration.between(BusDemo.start, LocalDateTime.now()).toMillis() / 1000;
        return ((duration / 5) + 1) * 10;
    }

    public static final Random random = new Random();
    public static int[] lToRSiteArray = {5, 6, 7, 8, 4, 3, 6, 5, 6, 7, 4, 3, 6, 8};
    public static int[] rToLSiteArray = {4, 7, 5, 6, 3, 4, 5, 3, 7, 4, 5, 4, 5, 4};
    public static final int[] wuCha = {-1, 0, 1};
    public static final AtomicLong atomicLong = new AtomicLong(0);
    public static final int siteTotal = 15;

    public static int getRealTimeCost(int siteNum, int[] siteArray) {
        if (siteNum == 14) {
            return 4;
        }
        if (siteNum == -1) {
            return 5;
        }
        System.out.println();
        final int i = random.nextInt(3);
        return siteArray[siteNum] + i;
    }


    //模拟公交车行驶以及掉头的动作
    public void nextSite() {
        if (lToR && siteNum < 14) {
            siteNum++;
        } else if (lToR && siteNum == 14) {
            lToR = false;
            siteNum=15;
        } else if (!lToR && siteNum > 1) {
            siteNum--;
        } else if (!lToR && siteNum == 1) {
            lToR = true;
            siteNum = 2;
        }
        System.out.println(siteNum);
    }

    //模拟一个站点到下一个站点的时间
    public int siteToSiteTimeCost(int siteNum) {
        int realTimeCost = 0;
        if (lToR) {
            realTimeCost = getRealTimeCost(siteNum, lToRSiteArray);
        }
        if (!lToR) {
            realTimeCost = getRealTimeCost(siteNum, rToLSiteArray);
        }
        return realTimeCost;
    }

    public void shangChe(int ckCount, int siteNum) {
        try {
            //TODO  1 要改成 10
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.cks = this.cks + ckCount;
    }

    public void xiqChe(int ckCount, int siteNum) {
        if (siteNum==15) {
            try {
                //TODO  1 要改成 10
                TimeUnit.SECONDS.sleep((ckCount));
                this.cks=0;
                System.out.println("乘客全部下车");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!this.lToR && siteNum==1) {
            try {
                //TODO  1 要改成 10
                TimeUnit.SECONDS.sleep((ckCount));
                this.cks=0;
                System.out.println("乘客全部下车");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            //TODO  1 要改成 10
            TimeUnit.SECONDS.sleep((ckCount * 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.cks = this.cks - ckCount;
//        System.out.println(siteNum + "站 下乘客 " + ckCount + "位");
    }

    //模拟每次下车人数
    public int xiaCheCKCount() {
        if (cks == 0) {
            return 0;
        }
        return random.nextInt(cks);

    }

    @Override
    public String toString() {
        return "Bus{" +
                "cks=" + cks +
                ", siteNum=" + siteNum +
                ", lToR=" + lToR +
                '}';
    }

    public static void main(String[] args) {

        final Bus bus = new Bus(0, 1, true);
        while (true) {
            //去下一站

            final int i = bus.siteToSiteTimeCost(bus.siteNum-1);
            try {
//                TimeUnit.SECONDS.sleep(i);
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bus.nextSite();
            System.out.print("到" + bus.siteNum + "站了 ");
            final int xiaCheCKCount = bus.xiaCheCKCount();
            System.out.print(xiaCheCKCount + "位乘客下车   ");
            bus.xiqChe(xiaCheCKCount, bus.siteNum);
            final long ck = bus.getCK();
            System.out.println(ck + "位乘客上车");
            bus.shangChe((int) ck, bus.siteNum);
            System.out.println(bus);
            System.out.println("----->");
        }
    }
}