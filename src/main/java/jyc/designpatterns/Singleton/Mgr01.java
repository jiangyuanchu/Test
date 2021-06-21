package jyc.designpatterns.Singleton;

/**
 * @Description 单例模式
 *
 * 饿汉式
 * 类加载到内存后，只实例化一个单例，JVM保证安全
 * 简单实用，推荐使用
 *
 * @ClassName Mgr01
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/27 20:17
 * @Version V1.0
 */
public class Mgr01 {

    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01(){}

    public static Mgr01 getInstance(){
        return INSTANCE;
    }

}
