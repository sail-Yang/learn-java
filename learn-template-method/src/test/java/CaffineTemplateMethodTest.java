import com.sailyang.caffine.Coffee;
import com.sailyang.caffine.Tea;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/8/26 16:54
 */
public class CaffineTemplateMethodTest {
    public static void main(String[] args) {
        System.out.println("tea ......");
        Tea tea = new Tea();
        System.out.println("tea is OK !");

        System.out.println("coffee ......");
        Coffee coffee = new Coffee();
        System.out.println("coffee is OK !");
    }
}
