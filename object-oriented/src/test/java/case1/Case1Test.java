package case1;

import case1.Child;
import org.junit.Test;

/**
 * @author yangfan
 * @version 1.0
 * @description: 在父类构造方法中调用可被overwrite的方法
 * @date 2024/8/15 9:18
 */
public class Case1Test {
    @Test
    /*
     * output：0 123
     * 首先初始化父类，父类构造方法中调用test()，此时test()被子类重写
     * 又因为此时子类的实例变量还没有赋值，所以输出默认值0
     */
    public static void main(String[] args) {
        Child c = new Child();
        c.test();
    }
    /*
     * 在父类构造方法中调用可被overwrite的方法不太好
     * 应该只调用private方法
     */
}
