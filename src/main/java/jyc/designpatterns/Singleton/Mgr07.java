package jyc.designpatterns.Singleton;

/**
 * @Description 单例模式
 *
 * 静态内部类(完美写法)
 *
 * @ClassName Mgr01
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/27 20:17
 * @Version V1.0
 */
public class Mgr07 {

    private Mgr07(){}

    private static class Mgr07Holder{
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    private static Mgr07 getInstance(){
        return Mgr07Holder.INSTANCE;
    }

}
