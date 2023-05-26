package com.neusoft;

import com.neusoft.dao.IUserDao;
import com.neusoft.entity.User;
import com.neusoft.service.IUserService;
import com.neusoft.service.IUserServiceImpl;
import com.neusoft.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class UserQuery {
    public static void main(String[] args) {
        IUserService iUserService = new IUserServiceImpl();
//             List<User> list= iUserDao.queryUserList();
//
//             for(User user :list){
//                 System.out.print(user.getName()+"  ");
//                 System.out.println(user.getId());
//             }

//     User user = iUserDao.getUserById(2);
//      System.out.println(user.getId());

//            User user =iUserDao.getUserByAll(1,"cmc");
//            System.out.println(user);


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

           User user= new User();
           user.setName("abc");
            user.setId(14);
            iUserService.deleteUser(user);
//            iUserService.modifyUser(user);
//           iUserDao.addUser(user);
//           //System.out.println(1/0);
//            sqlSession.commit();//必须提交，否则不入库

    }
}
