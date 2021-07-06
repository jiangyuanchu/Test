package jyc.designpatterns.AbstractFactory;

/**
 * @Description todo
 * @ClassName ModenFactory
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/7/6 20:47
 * @Version V1.0
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
