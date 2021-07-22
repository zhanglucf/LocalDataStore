package com.jvm;

/**
 * @author zzh
 * @date 2021年07月21日
 */
public class OOM_UnableToCreateNativeThread {

    /**
     * -Xmx1g -XX:+PrintGCDetails
     -XX:MaxDirectMemorySize=100m
     -Xss:指定栈空间大小
     */
    public static void main(String[] args) {
        for (int i = 0; i <1500000 ; i++) {
            System.out.println(i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ThreadLocal tl= new ThreadLocal<Byte[]>();
                        Byte[] b = new Byte[1024*1024*10];
                        tl.set(b);
                        Thread.sleep(Integer.MAX_VALUE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
