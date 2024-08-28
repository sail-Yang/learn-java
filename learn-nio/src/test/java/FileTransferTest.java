import java.io.*;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yangfan
 * @version 1.0
 * @description: 对比NIO和BIO在操作文件上的速度差异，可以发现小文件NIO快，大文件反而BIO快，因为NIO的主要使用场景是网络
 * @date 2024/8/27 17:33
 */
public class FileTransferTest {
    /*
     * @description: 使用BIO的方式传输文件
     *
     */
    private long transferFileWithBIO(File source, File dest) throws IOException {
        long startTime = System.currentTimeMillis();

        if(!dest.exists()){
            dest.createNewFile();
        }

        //创建输入输出流
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(dest));

        //传输数据
        byte[] bytes = new byte[1024 * 1024];
        int len;
        while((len = bin.read(bytes)) != -1){
            bout.write(bytes, 0 ,len);
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /*
     * @description: 使用NIO的方式传输文件
     */
    private long transferFileWithNIO(File source, File dest) throws IOException {
        long startTime = System.currentTimeMillis();

        if(!dest.exists()){
            dest.createNewFile();
        }

        //创建随机存取文件对象
        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(dest, "rw");

        //获取文件通道
        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();

        //创建并使用ByteBuffer传输数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
        while(readChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        //关闭文件通道
        writeChannel.close();
        readChannel.close();

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) throws URISyntaxException {
        FileTransferTest fileTransferTest = new FileTransferTest();
        File source = new File(FileTransferTest.class.getResource("source.rar").toURI());
        File bioDest = new File("bio.rar");
        File nioDest = new File("nio.rar");

        try {
            long time = fileTransferTest.transferFileWithBIO(source,bioDest);
            System.out.println("BIO Time: " + time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            long time = fileTransferTest.transferFileWithNIO(source,nioDest);
            System.out.println("NIO Time: " + time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
