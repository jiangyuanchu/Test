package jyc.designpatterns.Builder.entity;

import jyc.designpatterns.Builder.Food;

/**
 * @description todo
 * @author jiangyuanchu
 * @data 2021/10/11 3:54 下午
 */
public class Tomato implements Food {
    @Override
    public void eat() {
        System.out.println("eat a tomato");
    }
}
