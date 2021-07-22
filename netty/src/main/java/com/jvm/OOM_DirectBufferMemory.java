package com.jvm;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzh
 * @date 2021年07月21日
 */
public class OOM_DirectBufferMemory {

    /**
     *  -Xmx1g -XX:+PrintGCDetails -XX:MaxDirectMemorySize=100m
     */
    public static void main(String[] args) {
        List<ByteBuffer> byteBuffers = new ArrayList<>();
        for (int i = 0; i < 2048; i++) {
            byteBuffers.add(ByteBuffer.allocateDirect(1024 * 1024));
        }
    }
}
