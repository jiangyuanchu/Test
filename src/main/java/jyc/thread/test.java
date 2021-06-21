package jyc.thread;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

public class test {

    public static void main(String[] args) {
        int num = 0;

        for(int i = 0 ; i < 1000; i++){
            num++;
        }

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("子线程异常");
        });

        thread.start();

        ThreadLocal a = new ThreadLocal(){
            @Override
            protected Object initialValue() {
                return super.initialValue();
            }
        };

        HashMap hashMap = new HashMap();
        for(int i = 0; i < 11; i++){
            //添加11个元素
            hashMap.put(i, i);
        }

        ConcurrentHashMap concurrentHashMap;

        System.out.println(num);




    }


    public boolean aaa(){
        return false;
    }
}
