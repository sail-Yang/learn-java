package protect;

import org.junit.Test;

/**
 * @author yangfan
 * @version 1.0
 * @description: protected和模板方法
 * @date 2024/8/15 9:33
 */
public class MainTest {
    @Test
    /*
        基类Base定义了对外行为方法action，还有两个可被重写的步骤step1,2
        子类通过重写protected方法step1和step2来修改对外行为
     */
    public static void main(String[] args) {
        Child c = new Child();
        c.action();
    }
}
