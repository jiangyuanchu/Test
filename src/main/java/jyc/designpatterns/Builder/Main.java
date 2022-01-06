package jyc.designpatterns.Builder;

import jyc.designpatterns.Builder.entity.Combo;

/**
 * @description todo
 * @author jiangyuanchu
 * @data 2021/10/11 3:50 下午
 */
public class Main {

    public static void main(String[] args) {
        ComboDirector comboDirector = new ComboDirector();
        Combo combo = comboDirector.doDirector(new HpComboBuilder());
        System.out.println(combo);
    }

}
