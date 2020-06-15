package wh.practice.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wanghuan
 */
public class Simple {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> aClass = Class.forName("wh.practice.reflect.Person");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, float.class);
        Object whh = declaredConstructor.newInstance("whh", 18, 180.0f);
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(whh, "whhhhhhh");
        Object o = name.get(whh);
        System.out.println(o);

        Method sing = aClass.getMethod("sing", String.class);
        Object alilialili = sing.invoke(whh, "alilialili");
        System.out.println(alilialili);

    }
}

class Person {
    private String name;
    private int age;
    private float height;
    Person(String name, int age, float height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public void sing(String song) {
        System.out.println("aaaaaaaaa~~~~~:"+song);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
