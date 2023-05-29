package com.neusoft.service;

import com.neusoft.entity.User;

public interface IUserService  {
    void addUser(User user);
    void modifyUser(User user);
    void deleteUser(User user);

}
