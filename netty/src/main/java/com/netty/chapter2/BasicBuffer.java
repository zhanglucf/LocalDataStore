package com.netty.chapter2;

import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * @author zzh
 * @date 2021年07月22日
 */
public class BasicBuffer {

    public static void main(String[] args) {

        IntBuffer buffer = IntBuffer.allocate(5);

        buffer.put(10);
        buffer.put(11);
        buffer.put(12);
        //将buffer进行读写切换
        Buffer flip = buffer.flip();
        //remaining 美[rɪˈmeɪnɪŋ] 还需处理的
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
