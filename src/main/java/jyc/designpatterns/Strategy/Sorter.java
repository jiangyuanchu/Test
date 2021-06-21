package jyc.designpatterns.Strategy;

import java.util.Arrays;

/**
 * @Description todo
 * @ClassName Sorter
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/29 15:10
 * @Version V1.0
 */
public class Sorter {

    public void sort(MyComparable[] array){
        Arrays.sort(array);
    }

    public void sort(int[] array){
        Arrays.sort(array);
    }

}
