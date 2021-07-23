package com.netty.chapter3;

import jdk.nashorn.internal.ir.IfNode;
import org.junit.Test;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * @author zzh
 * @date 2021年07月23日
 */
public class NIOFileChannel01 {

    @Test
    public void writeToFile() throws IOException {

        FileOutputStream outputStream = new FileOutputStream("D:\\LocalDataStore\\netty\\src\\main\\filetmp\\NIOFileChannel01.txt");

        FileChannel outChannel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put("你好，NIO".getBytes());

        buffer.flip();

        outChannel.write(buffer);

        outputStream.close();

    }

    @Test
    public void readFileToConsole() throws IOException {
        File file = new File("D:\\LocalDataStore\\netty\\src\\main\\filetmp\\NIOFileChannel01.txt");

        FileInputStream inputStream = new FileInputStream(file);
        //获取channel
        FileChannel inputStreamChannel = inputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //创建缓冲区
        //ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
        //把数据读取到buffer
        inputStreamChannel.read(buffer);
        //读写反转
        buffer.flip();

        byte[] array = buffer.array();

//        System.out.println(new String(array));

        System.out.println(new String(array,0,buffer.limit()));

    }

    @Test
    public void readFileToFile() throws IOException {
        File fromFile = new File("D:\\LocalDataStore\\netty\\src\\main\\filetmp\\NIOFileChannel01.txt");
        File fileCopy = new File("D:\\LocalDataStore\\netty\\src\\main\\filetmp\\NIOFileChannel01-copy.txt");
        FileInputStream intputStream = new FileInputStream(fromFile);
        FileOutputStream outputStream = new FileOutputStream(fileCopy);
        FileChannel intputStreamChannel = intputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(8);
        //创建缓冲区
        //ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
        while (true){
            int read = intputStreamChannel.read(buffer);
            if (read == -1 || read == 0) {
                break;
            }else {
                buffer.flip();
                FileChannel outputStreamchannel = outputStream.getChannel();
                outputStreamchannel.write(buffer);
                buffer.clear();
            }
        }
        outputStream.close();
    }

    @Test
    public void transferFrom() throws IOException {
        File fromFile = new File("D:\\LocalDataStore\\netty\\src\\main\\filetmp\\1.png");
        File fileCopy = new File("D:\\LocalDataStore\\netty\\src\\main\\filetmp\\1-copy.png");
        FileInputStream intputStream = new FileInputStream(fromFile);
        FileOutputStream outputStream = new FileOutputStream(fileCopy);
        FileChannel intputStreamChannel = intputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();
        outputStreamChannel.transferFrom(intputStreamChannel,0,fromFile.length());
        outputStream.close();
    }

    @Test
    public void onlyRead() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        for (int i = 0; i < 64; i++) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.flip();

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();

        System.out.println(readOnlyBuffer.getClass());

        while (readOnlyBuffer.hasRemaining()){
            System.out.println(readOnlyBuffer.get());
        }
        readOnlyBuffer.put((byte) 1);
    }


}
