package com.neusoft.entity;

public class User {
    private String name;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//mybatis 必须有无参构造方法！！！！！！

}
