package com.sailyang.caffine;

/**
 * @author yangfan
 * @version 1.0
 * @description: 咖啡
 * @date 2024/8/26 16:53
 */
public class Coffee extends CaffeineBeverage{
    public Coffee() {
        super.prepareRecipe();
    }
    @Override
    void brew() {
        System.out.println("咖啡需要直接泡");
    }

    @Override
    void addCondiments() {
        System.out.println("咖啡需要白开水等");
    }
}
