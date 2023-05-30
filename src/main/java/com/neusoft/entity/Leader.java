package com.neusoft.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//Leader to User : Many to Many
@Data
public class Leader {
    private int id;
    private String lname;
    private List<User> userList = new ArrayList<User>();
}
