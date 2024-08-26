package com.sailyang.caffine;

/**
 * @author yangfan
 * @version 1.0
 * @description: 模板基类(咖啡或茶的冲泡步骤模板)
 * @date 2024/8/26 16:53
 */
public abstract class CaffeineBeverage {
    private static final boolean DEFAULT_ADD_CONDIMENTS = true;

    /**
    不允许改变的行为加上final
    这里冲泡步骤不允许改变
     */
    final void prepareRecipe() {
        boilWater();

        brew();

        pourInCup();

        /**
         * 回调钩子
         */
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
    * 冲泡，需要子类实现
     */
    abstract void brew();

    /**
     * 添加调料，需要子类实现
     */
    abstract void addCondiments();

    /**
     * 将水煮沸
     */
    final void boilWater() {
        System.out.println("将水煮沸");
    }

    /**
     * 将水倒进杯子
     */
    final void pourInCup() {
        System.out.println("将水倒入杯中");
    }

    boolean customerWantsCondiments() {
        return DEFAULT_ADD_CONDIMENTS;
    }
}
