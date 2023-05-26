package com.neusoft;

import com.neusoft.dao.IUserDao;
import com.neusoft.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//     User user = iUserDao.getUserById(2);
//      System.out.println(user.getId());

            User user =iUserDao.getUserByAll(1,"cmc");
            System.out.println(user);


//            Map is an interface so you can't create an object directly
//            Map<String,Object> map = new HashMap<String, Object>();
//            map.put("name","cmc");
//            List<User> list =iUserDao.getUserByMap(map);
//            for(User user :list){
//                 System.out.print(user.getName()+"  ");
//                 System.out.println(user.getId());
//             }
//
//           User conditionObject = new User();
//           conditionObject.setId(1);
//           conditionObject.setName("jason");
//           User user = iUserDao.getUserByObject(conditionObject);
//            System.out.println(user.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
