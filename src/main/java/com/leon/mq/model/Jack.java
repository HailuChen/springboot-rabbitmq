package com.leon.mq.model;

/**
 * @author chenhailu
 * @date 2018/7/10 16:25
 */
public class Jack extends User{

    private static final long serialVersionUID = 3636888465918536087L;

    public Jack() {
        this.setAge(10);
        this.setCountry("china");
        this.setName("jack");
    }

    @Override
    public String toString() {
        return "my name is "+ this.getName()+ " , " + this.getAge()+" years old ,i'm from " + this.getCountry();
    }
}
