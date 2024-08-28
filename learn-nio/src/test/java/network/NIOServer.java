package network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/8/27 18:30
 */
public class NIOServer {
    public static void main(String[] args) {
        try {
            // 创建 ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 绑定端口
            serverSocketChannel.bind(new InetSocketAddress(8082));
            // 设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);

            //创建Selector
            Selector selector = Selector.open();
            //将ServerSocketChannel注册到Selector，关注OP_ACCPET
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while(true) {
                //阻塞直到有事件
                selector.select();
                //获取事件的key
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while(iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    //处理完后，从selectedKeys集合中移除
                    iterator.remove();

                    //判断事件类型
                    if(key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector,SelectionKey.OP_READ);
                    } else if(key.isReadable()){
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        client.read(buffer);
                        buffer.flip();
                        client.write(buffer);
                        client.close();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
