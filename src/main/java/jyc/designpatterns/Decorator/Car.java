package jyc.designpatterns.Decorator;
/**
 * @description 车（接口）
 * @author jiangyuanchu
 * @data 2021/10/11 3:04 下午
 */
public interface Car {

    /**
     * 所有的车都可以开
     */
    void start();

    /**
     * 所有的车都有价格
     * @return 价格
     */
    int value();

}
