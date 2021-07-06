package jyc.designpatterns.FactoryMethod;

/**
 * @Description 简单工厂
 *
 *   拓展性不好
 *
 * @ClassName SimpleVehicleFactory
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/7/6 20:19
 * @Version V1.0
 */
public class SimpleVehicleFactory {

    public Moveable create() {

        return new Car();
    }
}
