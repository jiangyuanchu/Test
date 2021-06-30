package jyc.designpatterns.Strategy;

/**
 * Cat 体重比较策略
 */
public class CatWeightCompareStrategy implements Comparator<Cat>{
    @Override
    public int compareTo(Cat o1, Cat o2) {
        if(o1.getWeight() > o2.getWeight()){
            return 1;
        }
        return -1;
    }
}
