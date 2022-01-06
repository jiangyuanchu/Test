package jyc.designpatterns.Decorator;
/**
 * @description 汽车装饰基类
 * @author jiangyuanchu
 * @data 2021/10/11 3:08 下午
 */
public abstract class CarDecorator implements Car{
    private Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void start() {
        car.start();
    }

    @Override
    public int value() {
        return car.value();
    }
}
