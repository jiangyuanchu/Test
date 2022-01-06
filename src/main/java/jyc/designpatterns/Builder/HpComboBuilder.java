package jyc.designpatterns.Builder;

import jyc.designpatterns.Builder.entity.CocaCola;
import jyc.designpatterns.Builder.entity.Combo;
import jyc.designpatterns.Builder.entity.Hamburger;

import java.util.ArrayList;
import java.util.List;

/**
 * @description todo
 * @author jiangyuanchu
 * @data 2021/10/11 4:24 下午
 */
public class HpComboBuilder extends ComboBuilder{

    private Combo combo;

    public HpComboBuilder(){
        this.combo = new Combo();
    }

    @Override
    public void setFoodList() {
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Hamburger());
        combo.setFoodList(foodList);
    }

    @Override
    public void setDrinkList() {
        List<Drink> drinkList = new ArrayList<>();
        drinkList.add(new CocaCola());
        combo.setDrinkList(drinkList);
    }

    @Override
    public Combo getCombo() {
        return this.combo;
    }
}
