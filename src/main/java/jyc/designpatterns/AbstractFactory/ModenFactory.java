package jyc.designpatterns.AbstractFactory;

/**
 * @Description todo
 * @ClassName ModenFactory
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/7/6 20:47
 * @Version V1.0
 */
public class ModenFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
