package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author yangfan
 * @version 1.0
 * @description: 客户端
 * @date 2024/8/27 18:30
 */
public class Client{
    public static void main(String[] args) throws InterruptedException {
        int clientCount = 10000;
        ExecutorService executorServiceBIO = Executors.newFixedThreadPool(10);
        ExecutorService executorServiceNIO = Executors.newFixedThreadPool(10);

        //BIO
        Runnable bioClient = () -> {
            try {
                Socket socket = new Socket("localhost",8080);
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
                out.write("Hello, 杨帆 BIO".getBytes());
                byte[] buffer = new byte[1024];
                in.read(buffer);
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        //NIO
        Runnable nioClient = () -> {
            try {
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.connect(new InetSocketAddress("localhost",8082));
                ByteBuffer buffer = ByteBuffer.wrap("Hello, 杨帆 NIO".getBytes());
                socketChannel.write(buffer);
                buffer.clear();
                socketChannel.read(buffer);
                socketChannel.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        //测试性能
        long startTime=System.currentTimeMillis(),endTime;
        for(int i=0;i<clientCount;i++){
            executorServiceBIO.execute(bioClient);
        }
        executorServiceBIO.shutdown();
        executorServiceBIO.awaitTermination(1, TimeUnit.MINUTES);
        endTime = System.currentTimeMillis();
        System.out.println("BIO Server do " + clientCount + " of client's time is " + (endTime - startTime));

        startTime=System.currentTimeMillis();
        for (int i = 0; i < clientCount; i++) {
            executorServiceNIO.execute(nioClient);
        }
        executorServiceNIO.shutdown();
        executorServiceNIO.awaitTermination(1, TimeUnit.MINUTES);
        endTime = System.currentTimeMillis();
        System.out.println("NIO Server do " + clientCount + " of client's time is " + (endTime - startTime));
    }
}
