import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/9/10 9:34
 */
public class ByteBufferTest {
    public static void main(String[] args) throws URISyntaxException {
        File source = new File(ByteBufferTest.class.getResource("data.txt").toURI());
        try (FileChannel fileChannel = new FileInputStream(source).getChannel()) {
            //创建ByteBuffer
            final ByteBuffer buffer = ByteBuffer.allocate(1024);
            //读取文件内容，并存入buffer
            fileChannel.read(buffer);
            //切换为读模式
            buffer.flip();
            while(buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            buffer.clear();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
