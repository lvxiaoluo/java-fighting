package org.example.io;

import java.io.Serializable;

/**
 * @author lvle
 * @date 2021-03-10 23:46
 */

public class User implements Serializable {

    private String name;

    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
