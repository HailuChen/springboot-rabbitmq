package com.leon.mq.model;

import java.io.Serializable;

/**
 * @author chenhailu
 * @date 2018/7/10 16:18
 */
public class User implements Serializable {

    private static final long serialVersionUID = 2924572556790983472L;
    private String name;

    private String country;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
