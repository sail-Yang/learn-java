package netty.halfpackage.v1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yangfan
 * @version 1.0
 * @description: 改进：固定数据大小
 * @date 2024/9/10 10:19
 */
public class ServerSocketV1 {
    private static final int BYTE_LENGTH = 1024; //字节数组长度
    public static void main(String[] args) throws IOException {
        //创建socket服务器
        ServerSocket serverSocket = new ServerSocket(9091);
        // 获取客户端连接
        Socket clientSocket = serverSocket.accept();
        try (InputStream inputStream = clientSocket.getInputStream()) {
            while (true) {
                //循环获取客户端发送的信息
                byte[] bytes = new byte[BYTE_LENGTH];
                //读取客户端发送的信息
                int count = inputStream.read(bytes, 0, BYTE_LENGTH);
                if (count > 0) {
                    //成功接收到有效信息并打印
                    System.out.println("接受到客户端信息：" + new String(bytes).trim());
                }
                count = 0;
            }
        }
    }
}
