package jyc.jvm.GC;

public class testPretenureSizeThreshold {

    public static void main(String[] args) {
        //JVM启动参数  -verbose:gc -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
        testPretenureSizeThreshold();
    }

    public static void testPretenureSizeThreshold(){
        byte[] allocation;

        allocation = new byte[4 * 1024 * 1024];

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
