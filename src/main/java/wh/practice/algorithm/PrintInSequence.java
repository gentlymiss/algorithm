package wh.practice.algorithm;

/**
 * @author wh
 */
public class PrintInSequence {

    public static void main(String[] args) {

        com.example.demo.ThreadA printFirst = new com.example.demo.ThreadA(20);
//        ThreadA printSecond = new ThreadA("second");
//        ThreadA printThird = new ThreadA("third");

        Thread thread1 = new Thread(printFirst, "A");
        Thread thread2 = new Thread(printFirst, "B");



        thread1.start();
        thread2.start();
    }
}

class ThreadA implements Runnable {
    private int n;
    boolean s = true;

    public ThreadA(int n) {
        this.n = n;
    }

    public synchronized void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (!s) {
                this.wait();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            System.out.println(i+":foo");
            s=false;
            this.notifyAll();
        }
    }

    public synchronized void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (s) {
                this.wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            System.out.println(i+":bar");
            s=true;
            this.notifyAll();
        }
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            if ("A".equals(threadName)) {
                System.out.println("A开始执行");
                foo();
            } else if ("B".equals(threadName)) {
                System.out.println("B开始执行");
                bar();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}