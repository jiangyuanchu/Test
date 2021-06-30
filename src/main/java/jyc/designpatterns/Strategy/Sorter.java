package jyc.designpatterns.Strategy;

import java.util.Arrays;

/**
 * @Description todo
 * @ClassName Sorter
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/29 15:10
 * @Version V1.0
 */
public class Sorter<T> {

    public void sort(T[] array, Comparator<T> comparator){
        for(int i = 0; i < array.length; i++){
            int minPos = i;
            for(int j = i + 1; j <  array.length; j++){
                minPos = comparator.compareTo(array[j], array[minPos]) == -1 ? j : minPos;
            }
            swap(array, i, minPos);
        }
    }

    private void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
