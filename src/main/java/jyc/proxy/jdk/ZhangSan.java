package jyc.proxy.jdk;

/**
 * @Description todo
 * @ClassName ZhangSan
 * @Author Jiang YuanChu[jiang_yc@suixingpay.com]
 * @Date 2021/4/23 15:01
 * @Version V1.0
 */
public class ZhangSan implements Person{

    private String sex = "龙";
    private String name = "敖丙";

    @Override
    public void findLove() {
        System.out.println("哪吒闹海");
    }
}
