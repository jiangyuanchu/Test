package jyc.designpatterns.Builder.entity;

import jyc.designpatterns.Builder.Packing;

/**
 * @description todo
 * @author jiangyuanchu
 * @data 2021/10/11 4:01 下午
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
