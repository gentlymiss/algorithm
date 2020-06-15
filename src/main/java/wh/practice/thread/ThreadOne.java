package wh.practice.thread;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wanghuan
 */
abstract class OrderlyPrint {
    String a = null;

    private static String b;
    static void s() {

    }

    public static void main(String[] args) {
        int a = 200, b=197;
        System.out.println(a+"aaa"+b);
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println(a+"aaa"+b);
    }
}


public class ThreadOne implements Runnable {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int a = 200, b=197;
        System.out.println(a+"aaa"+b);
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println(a+"aaa"+b);
    }
    @Override
    public void run() {
        System.out.println();
    }
}
