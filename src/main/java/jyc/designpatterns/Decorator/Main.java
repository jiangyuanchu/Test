package jyc.designpatterns.Decorator;
/**
 * @description 装饰模式
 *
 *      类图：  https://www.processon.com/diagraming/6163e8dc1efad41d824e322f
 *
 * @author jiangyuanchu
 * @data 2021/10/11 3:03 下午
 */
public class Main {

    public static void main(String[] args) {
        Car car1 = new AodiCar();
        System.out.println(car1.value());
        car1.start();

        Car car2 = new ToyotaCar();
        car2 = new AutoDriverCarDecorator(car2);
        car2 = new GPSCarDecorator(car2);
        System.out.println(car2.value());
        car2.start();
    }

}
