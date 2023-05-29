package com.neusoft.dao;

import com.neusoft.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    List<User> queryUserList();
   User getUserById(int id);

   //#与$的区别：#=直接放入参数（字符串=参数） $=直接拼接字符串（字符串=字符串）
   User getUserByName(String name);

   //如果在这里写了@Param,则XML文件不需要写parameterType
   User getUserByAll(@Param("id") int id,@Param("name") String name);
    List<User> getUserByMap(Map<String,Object> map);
    User getUserByObject(User user);

    User getUserAndCardById(int id);

    void addUser(User user);
    void modifyUser(User user);
    void deleteUser (User user);
}
