package protect;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/8/15 9:32
 */
public class Child extends Base{
    @Override
    protected void step1() {
        System.out.println("child step" + this.currentStep);
    }

    @Override
    protected void step2() {
        System.out.println("child step" + this.currentStep);
    }
}
