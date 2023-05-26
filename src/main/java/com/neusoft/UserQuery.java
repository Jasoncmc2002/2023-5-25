package com.neusoft;

import com.neusoft.dao.IUserDao;
import com.neusoft.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserQuery {
    public static void main(String[] args) {
        //Run mybatis
        try {
            //1.Read mybatis-config.xml(Configuration file)
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

            //2.Create SqlSessionFactory Object
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            //3.Create SqlSession Object(=connection in JDBC)
             SqlSession sqlSession = sqlSessionFactory.openSession();

             //4.Get Dao object to execute query with the tech of Reflect
             IUserDao iUserDao =sqlSession.getMapper(IUserDao.class);
//             List<User> list= iUserDao.queryUserList();
//
//             for(User user :list){
//                 System.out.print(user.getName()+"  ");
//                 System.out.println(user.getId());
//             }
     User user = iUserDao.getUserById(2);
      System.out.println(user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
