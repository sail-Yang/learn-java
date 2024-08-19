import com.sailyang.Size;
import org.junit.Test;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/8/19 20:04
 */
public class EnumTest {
    @Test
    public static void main(String[] args) {
        Size s = Size.MEDIUM;
        System.out.println(s.getAbbr());
        s = Size.fromAbbr("L");
        System.out.println(s.getTitle());
    }
}
