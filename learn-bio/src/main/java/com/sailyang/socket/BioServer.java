package com.sailyang.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangfan
 * @version 1.0
 * @description: BIO 简单TCP服务器
 * @date 2024/8/28 15:12
 */
public class BioServer {
    public static void main(String[] args) throws IOException{
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //启动一个serverSocket
        //默认是对每个client都会建立一个线程与之通讯
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("server starting ....");
        while(true) {
            final Socket socket = serverSocket.accept();
            System.out.println("accept one connection");
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    handle(socket);
                }
            });
        }

    }

    public static void handle(Socket socket) {
        System.out.println("threadId: " + Thread.currentThread().getId());
        try{
            byte[] bytes = new byte[1024];
            //通过sockets读取输入流
            InputStream inputStream = socket.getInputStream();
            while(true) {
                System.out.println("threadId: " + Thread.currentThread().getId() + "wait reading");
                int read = inputStream.read(bytes);
                if (read != -1) {
                    String readStr = new String(bytes, 0, read);
                    System.out.println("threadId: " + Thread.currentThread().getId() + "\t" + readStr);
                }else{
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("close connection");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
