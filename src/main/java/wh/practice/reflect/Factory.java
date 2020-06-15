package wh.practice.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author wanghuan
 */
public class Factory {
    private Factory(){}

    private static Factory f = new Factory();
    private static Properties pr;

    static {
        pr = new Properties();
        try {
            pr.load(new FileReader(Objects.requireNonNull(Factory.class.getClassLoader().getResource("application.properties")).getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Factory getInstance() {
        return f;
    }

    public <T> T newInstance(Class<T> tClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String simpleName = tClass.getSimpleName();
        String name = pr.getProperty(simpleName);

        return (T)Class.forName(name).newInstance();
    }
}

class Main{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Factory f = Factory.getInstance();
        Fruit fruit = f.newInstance(Fruit.class);
        fruit.type();
    }
}
