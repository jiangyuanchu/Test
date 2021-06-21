package jyc.designpatterns.Strategy;

import java.util.Arrays;

/**
 * @Description todo
 * @ClassName Main
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/29 15:09
 * @Version V1.0
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {9, 2, 3, 5, 7, 1, 4};
        Cat[] cats = {new Cat(5), new Cat(1), new Cat(3)};
        Sorter sorter = new Sorter();
        sorter.sort(cats);
        System.out.println(Arrays.toString(cats));
    }


}
