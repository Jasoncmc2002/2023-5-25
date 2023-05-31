package com.neusoft.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Card implements Serializable {
    private int id;
    private int uid;
    private String name;
}
