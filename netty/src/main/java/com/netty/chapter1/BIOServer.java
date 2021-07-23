package com.netty.chapter1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zzh
 * @date 2021年07月22日
 */
public class BIOServer {

    //telnet 127.0.0.1 6666
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");
                while (true){
                    System.out.println(Thread.currentThread().getName() + "- 等待客户端建立连接----");
                    Socket accept = serverSocket.accept();
                    System.out.println("----与客户端建立连接----");
                    System.out.println(Thread.currentThread().getName() + " 连接一个客户端");
                    executorService.execute(()->handler(accept));
                }
    }

    public static void handler(Socket socket){
        System.out.println();

        byte[] bytes = new byte[1024];
        try {
            InputStream inputStream = socket.getInputStream();
            while (true){
                System.out.println(Thread.currentThread().getName() + "- 等待客户端发送消息----");
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(Thread.currentThread().getName() + " : " +new String(bytes,0,read));
                }else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("关闭和客户端的连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
