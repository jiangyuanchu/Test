package jyc.designpatterns.Decorator;
/**
 * @description 奥迪车
 * @author jiangyuanchu
 * @data 2021/10/11 3:05 下午
 */
public class AodiCar implements Car{

    @Override
    public void start() {
        System.out.println("奥迪 tu tu tu ....");
    }

    @Override
    public int value() {
        return 40;
    }

}
