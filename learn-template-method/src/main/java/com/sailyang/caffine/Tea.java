package com.sailyang.caffine;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/8/26 16:53
 */
public class Tea extends CaffeineBeverage{
    public Tea() {
        super.prepareRecipe();
    }

    @Override
    void brew() {
        System.out.println("泡茶需要将80度左右的水将茶叶泡开了！");
    }

    @Override
    void addCondiments() {
        System.out.println("泡茶需要柠檬水等！");
    }
}
