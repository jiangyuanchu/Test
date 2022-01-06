package jyc.designpatterns.Builder;

import jyc.designpatterns.Builder.entity.Combo;

/**
 * @description todo
 * @author jiangyuanchu
 * @data 2021/10/11 3:57 下午
 */
public abstract class ComboBuilder {

    /**
     * 设置套餐内食物
     */
    public abstract void setFoodList();

    /**
     * 设置套餐内饮品
     */
    public abstract void setDrinkList();

    /**
     * 获取实体对象
     * @return
     */
    public abstract Combo getCombo();
}
