package jyc.thread.lock;

public class ClassLoadDeadLock {

    public static void main(String[] args) {
        new Thread(() -> {
            A.test();
        }).start();

        new Thread(() -> {
            B.test();
        }).start();
    }

}

class A {
    static {
        System.out.println("A-init");
        B.test();
    }

    public static void test(){
        System.out.println("A--test");
    }
}

class B {
    static {
        System.out.println("B-init");
        A.test();
    }

    public static void test(){
        System.out.println("B--test");
    }
}