package jyc.designpatterns.Builder.entity;

import jyc.designpatterns.Builder.Drink;

/**
 * @description todo
 * @author jiangyuanchu
 * @data 2021/10/11 3:55 下午
 */
public class CocaCola implements Drink {
    @Override
    public void drink() {
        System.out.println("drink a CocaCola");
    }
}
