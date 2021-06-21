package jyc.designpatterns.Singleton;

/**
 * @Description 单例模式
 *
 * lazy loading
 * 懒汉式
 * 按需初始化 线程不安全
 *
 * @ClassName Mgr01
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/27 20:17
 * @Version V1.0
 */
public class Mgr03 {

    private static Mgr03 INSTANCE;

    private Mgr03(){}

    public static Mgr03 getInstance(){
        if(INSTANCE == null){
            try{
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            new Thread(() -> System.out.println(Mgr03.getInstance().hashCode())).start();
        }
    }


}
