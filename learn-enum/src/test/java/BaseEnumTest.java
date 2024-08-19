import com.sailyang.BaseSize;
import org.junit.Test;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/8/19 19:55
 */
public class BaseEnumTest {
    @Test
    public static void main(String[] args) {
        /*
        * 获取字面值和比较
        */
        BaseSize baseSize = BaseSize.LARGE;
        System.out.println(baseSize);
        System.out.println(baseSize == BaseSize.LARGE);

        /*
         * switch
         */
        switch (baseSize) {
            case SMALL -> System.out.println("small");
            case MEDIUM -> System.out.println("medium");
            case LARGE -> System.out.println("large");
        }
    }
}
