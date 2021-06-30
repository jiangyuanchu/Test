package jyc.designpatterns.Strategy;

/**
 * @Description todo
 * @ClassName Cat
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/29 15:44
 * @Version V1.0
 */
public class Cat {

    private int age;

    private int weight;

    public Cat(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", weight=" + weight +
                '}';
    }
}
