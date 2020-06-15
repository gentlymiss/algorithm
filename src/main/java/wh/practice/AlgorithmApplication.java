package wh.practice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wanghuan
 */
public class AlgorithmApplication {
    public static void main(String[] args) {
//        ThA thA = new ThA();
//        Thread thread1 = new Thread(thA);
//        Thread thread2 = new Thread(thA);
//        thread1.start();
//        thread2.start();
    }
}


class ThA implements Runnable {

    AtomicInteger a = new AtomicInteger(0);
    AtomicInteger b = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i<10000; i++) {
            a.incrementAndGet();
        }
        System.out.println(a);
    }
}
