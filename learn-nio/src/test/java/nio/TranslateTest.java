package nio;

import com.sailyang.netty.ByteBufferUtil;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/9/10 9:46
 */
public class TranslateTest {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2;
        String str3;
        //通过StandardCharsets的encode方法获得ByteBuffer
        // 此时获得的ByteBuffer为读模式，无需通过flip切换模式
        ByteBuffer buffer = StandardCharsets.UTF_8.encode(str1);
        // 也使用wrap方法，不用flip
        ByteBuffer wrap = ByteBuffer.wrap(str1.getBytes());
        ByteBufferUtil.debugAll(wrap);
        ByteBufferUtil.debugAll(buffer);

        // 将缓冲区中的数据转化为字符串
        // 通过StandardCharsets解码，获得CharBuffer，再通过toString获得字符串
        str3 = StandardCharsets.UTF_8.decode(wrap).toString();
        System.out.println(str3);
    }
}
