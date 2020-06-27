package wh.practice.algorithm;

import java.util.Arrays;

/**
 * @author wh
 */
public class ZeroEvenOdd {
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();

        Thread a = new Thread(threadB, "A");
        Thread b = new Thread(threadB, "B");
        Thread c = new Thread(threadB, "C");

        a.start();
        b.start();
        c.start();

        Arrays.asList( "a", "b", "d" ).forEach( aa -> {
            System.out.print( aa );
            System.out.print( aa );
        });
    }
}

class ThreadB implements Runnable {

    int a = 0, b = 0, n = 18;

    public synchronized void zero() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (a % 2 != 0) {
                this.wait();
            }
            System.out.print("0");
            System.out.println("a:" + a);
            a++;
            this.notifyAll();
        }
    }

    public synchronized void odd() throws InterruptedException {
        for (int i = 0; i < Math.ceil(n/2.0); i++) {
            while (a % 4 != 1) {
                this.wait();
            }
            b++;
            System.out.print(b);
            System.out.println("a:" + a);
            a++;
            this.notifyAll();
        }

    }

    public synchronized void even() throws InterruptedException {
        for (int i = 0; i < n/2; i++) {
            while (a % 4 != 3) {
                this.wait();
            }
            b++;
            System.out.print(b);
            System.out.println("a:" + a);
            a++;
            this.notifyAll();
        }
    }

    @Override
    public void run() {
        try {
                if ("A".equals(Thread.currentThread().getName())) {
                    zero();
                } else if ("B".equals(Thread.currentThread().getName())) {
                    even();
                } else if ("C".equals(Thread.currentThread().getName())) {
                    odd();
                }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}