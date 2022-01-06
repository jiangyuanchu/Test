package jyc.designpatterns.Decorator;
/**
 * @description 奥迪车
 * @author jiangyuanchu
 * @data 2021/10/11 3:05 下午
 */
public class ToyotaCar implements Car{

    @Override
    public void start() {
        System.out.println("丰田 da da da ....");
    }

    @Override
    public int value() {
        return 30;
    }

}
