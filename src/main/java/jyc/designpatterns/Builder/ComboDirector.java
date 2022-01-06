package jyc.designpatterns.Builder;

import jyc.designpatterns.Builder.entity.Combo;

/**
 * @description 指导者
 * @author jiangyuanchu
 * @data 2021/10/11 4:23 下午
 */
public class ComboDirector {

    public Combo doDirector(HpComboBuilder builder){
        builder.setFoodList();
        builder.setDrinkList();
        return builder.getCombo();
    }

}
