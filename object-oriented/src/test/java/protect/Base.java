package protect;

/**
 * @author yangfan
 * @version 1.0
 * @description: protected 探究
 * @date 2024/8/15 9:30
 */
public class Base {
    protected int currentStep;

    protected void step1() {

    }

    protected void step2() {

    }

    /*
    *   对外提供的行为，内部有两个步骤step1和step2
     */
    public void action() {
        this.currentStep = 1;
        step1();
        this.currentStep = 2;
        step2();
    }

}
