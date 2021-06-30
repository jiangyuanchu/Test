package jyc.designpatterns.Strategy;

/**
 * @Description todo
 * @ClassName Main
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/29 15:09
 * @Version V1.0
 */
public class Main {

    public static void main(String[] args) {

        Cat[] cats = new Cat[]{new Cat(1,1), new Cat(5,5), new Cat(3,3)};
        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(cats, new CatWeightCompareStrategy());
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }

    }


}
