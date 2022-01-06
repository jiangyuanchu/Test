package jyc.designpatterns.Decorator;
/**
 * @description 自动驾驶技术装饰器
 * @author jiangyuanchu
 * @data 2021/10/11 3:14 下午
 */
public class GPSCarDecorator extends CarDecorator{

    public GPSCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Ding～GPS已开启");
    }

    @Override
    public int value() {
        return super.value() + 2;
    }
}
