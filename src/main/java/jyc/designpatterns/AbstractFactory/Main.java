package jyc.designpatterns.AbstractFactory;

/**
 * @Description  抽象工厂
 *
 *      产品族 （类似于 游戏换皮肤？）
 *      类图参考 processOn
 *
 *      question: 为什么抽象工厂不用接口实现？
 *      answer： 语义问题，形容词用接口，名词用抽象类
 *
 * @ClassName Main
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/7/6 20:06
 * @Version V1.0
 */
public class Main {

    public static void main(String[] args) {
//        Car c = new Car();
//        c.go();
//        AK47 w = new AK47();
//        w.shoot();
//        Braad braad = new Braad();
//        braad.printName();

        AbstractFactory factory = new MagicFactory();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Weapon weapon = factory.createWeapon();
        weapon.shoot();
        Food food = factory.createFood();
        food.printName();

        AbstractFactory factory1 = new ModenFactory();
        Vehicle vehicle1 = factory1.createVehicle();
        vehicle1.go();
        Weapon weapon1 = factory1.createWeapon();
        weapon1.shoot();
        Food food1 = factory1.createFood();
        food1.printName();
    }

}
