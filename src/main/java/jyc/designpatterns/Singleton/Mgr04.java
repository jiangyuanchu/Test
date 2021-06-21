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
public class Mgr04 {

    private static Mgr04 INSTANCE;

    private Mgr04(){}

    public static synchronized Mgr04 getInstance(){
        if(INSTANCE == null){
            try{
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            new Thread(() -> System.out.println(Mgr04.getInstance().hashCode())).start();
        }
    }


}
