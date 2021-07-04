package org.example.serializable;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lvle
 * @date 2021-02-20 17:26
 */
public class User implements Serializable {

    private static final long serialVersionUID = -3277200094046405258L;

    private String name;

    private int age;

    private transient String gener;

    private Date birthday;

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

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gener='" + gener + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
