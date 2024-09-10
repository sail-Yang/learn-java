package netty.halfpackage.base;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/9/10 10:09
 */
public class ClientSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        final String message = "Hi,java.";
        try(OutputStream outputStream = socket.getOutputStream()) {
            //发送十次消息
            for(int i=0;i<10;i++){
                outputStream.write(message.getBytes());
            }
        }
    }
}
