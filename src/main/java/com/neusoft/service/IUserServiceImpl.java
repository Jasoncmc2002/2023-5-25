package com.neusoft.service;

import com.neusoft.dao.IUserDao;
import com.neusoft.entity.User;
import com.neusoft.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
//Service层：业务逻辑(!!!!)+参数组装+事务控制(commit+rollback)
public class IUserServiceImpl implements IUserService {

    public void addUser(User user) {
        SqlSession sqlSession =null;
        try {
            sqlSession = MybatisUtil.getSession();
            //4.Get Dao object to execute query with the tech of Reflect
            IUserDao iUserDao =sqlSession.getMapper(IUserDao.class);
            iUserDao.addUser(user);
            sqlSession.commit();
        }catch (Exception e){//或只写IOException-->只捕捉数据库链接异常
            sqlSession.rollback();
            e.printStackTrace();
           // System.out.println("ROLLBACK!");
        }finally {
            sqlSession.close();
        }

    }
    public void modifyUser(User user){
        SqlSession sqlSession =null;
        try {
            sqlSession = MybatisUtil.getSession();
            //4.Get Dao object to execute query with the tech of Reflect
            IUserDao iUserDao =sqlSession.getMapper(IUserDao.class);
           iUserDao.modifyUser(user);
            sqlSession.commit();
        }catch (Exception e){//或只写IOException-->只捕捉数据库链接异常
            sqlSession.rollback();
            e.printStackTrace();
            // System.out.println("ROLLBACK!");
        }finally {
            sqlSession.close();
        }

    }
    //正常不能直接做删除！！！！
    // -->表中要有一个flag列，删除=将flag的值改变（delete actually=modify）
    public void deleteUser(User user){
        SqlSession sqlSession =null;
        try {
            sqlSession = MybatisUtil.getSession();
            //4.Get Dao object to execute query with the tech of Reflect
            IUserDao iUserDao =sqlSession.getMapper(IUserDao.class);
            iUserDao.deleteUser(user);
            sqlSession.commit();
        }catch (Exception e){//或只写IOException-->只捕捉数据库链接异常
            sqlSession.rollback();
            e.printStackTrace();
            // System.out.println("ROLLBACK!");
        }finally {
            sqlSession.close();
        }

    }
}
