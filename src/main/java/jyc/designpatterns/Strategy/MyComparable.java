package jyc.designpatterns.Strategy;

/**
 * @Description todo
 * @ClassName MyComparable
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/29 16:40
 * @Version V1.0
 */
public interface MyComparable<T> extends Comparable<T> {

    int compareTo(T o);

}
