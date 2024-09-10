package netty.halfpackage.v3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/9/10 10:35
 */
public class ClientSocketV3 {
    public static void main(String[] args) throws IOException {
        // 启动 Socket 并尝试连接服务器
        Socket socket = new Socket("127.0.0.1", 9092);
        final String message = "Hi,Java."; // 发送消息
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()))) {
            // 给服务器端发送 10 次消息
            for (int i = 0; i < 10; i++) {
                // 注意:结尾的 \n 不能省略,它表示按行写入
                bufferedWriter.write(message + "\n");
                // 刷新缓冲区(此步骤不能省略)
                bufferedWriter.flush();
            }
        }
    }
}
