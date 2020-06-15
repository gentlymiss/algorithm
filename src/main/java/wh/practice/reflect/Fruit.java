package wh.practice.reflect;

/**
 * @author wanghuan
 */
public interface Fruit {
    void type();
}

class Apple implements Fruit {

    @Override
    public void type() {
        System.out.println("it is a apple");
    }
}

class Orange implements Fruit {

    @Override
    public void type() {
        System.out.println("it is a orange");
    }
}
