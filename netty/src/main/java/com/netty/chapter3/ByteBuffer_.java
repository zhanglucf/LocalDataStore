package com.netty.chapter3;

import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;

public class ByteBuffer_ {
    public static void main(String[] args) {
        final ByteBuffer buffer = ByteBuffer.allocate(16);

        buffer.putChar('你');
        buffer.flip();
        System.out.println(buffer.getChar());
    }
}
