package jyc.designpatterns.Strategy;

/**
 * @Description todo
 * @ClassName Cat
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/29 15:44
 * @Version V1.0
 */
public class Cat implements MyComparable<Cat> {

    private int age;

    public Cat(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        return this.age - o.age;
    }
}
