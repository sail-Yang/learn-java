package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/8/27 18:30
 */
public class BIOServer {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8080);

            while(true) {
                Socket client = serverSocket.accept();
                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead = in.read(buffer);
                out.write(buffer, 0, bytesRead);

                in.close();
                out.close();
                client.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
