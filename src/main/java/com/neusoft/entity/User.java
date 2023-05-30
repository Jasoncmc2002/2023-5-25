package com.neusoft.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//Create getter+setter+toString automatically
@Data
public class User {

    private String name;
    private int id;
    private int cardid;
//mybatis 必须有无参构造方法！！！！！！
    //否则编译错误！！！！！！
    private Card card;
    private List<Order> orderList = new ArrayList<Order>();
    //many to many
    private List<Leader> leaderList = new ArrayList<Leader>();
}
