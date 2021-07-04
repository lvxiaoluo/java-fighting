package org.example.reflect;

/**
 * @author lvle
 * @date 2021-03-11 22:27
 * 构造工厂类
 * 也就是说以后如果我们在添加其他的实例的时候只需要修改工厂类就行了
 */
public class OneFactory {
    public static Fruit getInstance(String fruitName){
        Fruit fruit = null;
        if ("Apple".equals(fruitName)){
            fruit = new Apple();
        }else if ("Orange".equals(fruitName)){
            fruit = new Orange();
        }
        return fruit;
    }

}
