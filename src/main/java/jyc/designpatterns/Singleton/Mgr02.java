package jyc.designpatterns.Singleton;

/**
 * @Description 单例模式 类似01
 * @ClassName Mgr01
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/27 20:17
 * @Version V1.0
 */
public class Mgr02 {

    private static final Mgr02 INSTANCE;
    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02(){}

    public static Mgr02 getInstance(){
        return INSTANCE;
    }

}
