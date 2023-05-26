package com.neusoft.dao;

import com.neusoft.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> queryUserList();
   User getUserById();
}
