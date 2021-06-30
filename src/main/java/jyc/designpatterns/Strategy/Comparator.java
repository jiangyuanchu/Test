package jyc.designpatterns.Strategy;

/**
 * 策略模式 比较器
 */
public interface Comparator<T> {

    int compareTo(T o1, T o2);

}
