package jyc.designpatterns.AbstractFactory;

/**
 * @Description 抽象工厂
 * @ClassName AbstractFactory
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/7/6 20:37
 * @Version V1.0
 */
public abstract class AbstractFactory {

    abstract Food createFood();

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();

}
