package extend_destroy;

import org.junit.Test;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/8/15 9:42
 */
public class MainTest {
    @Test
    /*
     *  预期输出：6，结果输出12
     * 子类addAll（做一次汇总）→父类addAll→子类add(做一次汇总)
     */
    public static void main(String[] args) {
        Child c = new Child();
        c.addAll(new int[]{1,2,3});
        System.out.println(c.getSum());
    }
    /*
        子类和父类之间是细节依赖，子类要知道父类怎么做的，父类也不能随便修改，会影响子类
     */
}
