package com.leon.mq.model;

/**
 * @author chenhailu
 * @date 2018/7/10 16:25
 */
public class Rose extends User{
    private static final long serialVersionUID = -3723519532746214345L;

    public Rose() {
        this.setAge(13);
        this.setCountry("american");
        this.setName("rose");
    }

    @Override
    public String toString() {
        return "my name is "+ this.getName()+ " , " + this.getAge()+" years old ,i'm from " + this.getCountry();
    }
}
