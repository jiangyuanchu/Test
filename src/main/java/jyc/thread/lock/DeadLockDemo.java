package jyc.thread.lock;

public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock(){
        Thread thread1 = new Thread(() -> {
            synchronized (A){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println("111");
                }
            }
        });


        Thread thread2 = new Thread(() -> {
            synchronized (B){
                synchronized (A){
                    System.out.println("2222");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
