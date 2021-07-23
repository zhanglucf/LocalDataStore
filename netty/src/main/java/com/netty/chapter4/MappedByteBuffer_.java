package com.netty.chapter4;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zzh
 * @date 2021年07月23日
 */
public class MappedByteBuffer_ {

    @Test
    public void modifyNonHeap() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0,(byte)'a');
        mappedByteBuffer.put(3,(byte)'C');

        randomAccessFile.close();
    }
}
