package com.neusoft.dao;

import com.neusoft.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    List<User> queryUserList();
   User getUserById(int id);
   //如果在这里写了@Param,则XML文件不需要写parameterType
   User getUserByAll(@Param("id") int id,@Param("name") String name);
    List<User> getUserByMap(Map<String,Object> map);
    User getUserByObject(User user);
}
