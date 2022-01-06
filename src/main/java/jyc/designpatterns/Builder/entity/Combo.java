package jyc.designpatterns.Builder.entity;

import jyc.designpatterns.Builder.Drink;
import jyc.designpatterns.Builder.Food;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description todo
 * @author jiangyuanchu
 * @data 2021/10/11 3:58 下午
 */
@Data
public class Combo {

    private List<Food> foodList;

    private List<Drink> drinkList;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        return "Combo {" +
                "foodList=" + foodList.stream().map(t -> sb.append(t.toString())).collect(Collectors.joining()) +
                ", drinkList=" + drinkList.stream().map(t -> sb2.append(t.toString())).collect(Collectors.joining()) +
                '}';
    }
}
