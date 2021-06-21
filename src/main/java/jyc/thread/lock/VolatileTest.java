package jyc.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileTest {

    private volatile int num = 0;

    private void thread(){

        Thread threadA = new Thread(() -> {
            while(true){
                if(num <= 50){
                    System.out.println("A"+(++num));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        Thread threadB = new Thread(() -> {
            while(true){
                if(num > 0) {
                    System.out.println("B"+(num));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.thread();
    }
}
