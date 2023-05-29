package com.neusoft.entity;

import lombok.Data;

@Data
public class Order {
    //一般不会设计外键，因为其消耗大量服务器资源
    private int uid;
    //不可让有业务含义的属性成为主键
    private int oid;
    private String time;
}
