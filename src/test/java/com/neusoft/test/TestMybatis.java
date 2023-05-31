package com.neusoft.test;

import com.neusoft.dao.ICardDao;
import com.neusoft.dao.ILeaderDao;
import com.neusoft.dao.IOrderDao;
import com.neusoft.dao.IUserDao;
import com.neusoft.entity.Card;
import com.neusoft.entity.Leader;
import com.neusoft.entity.Order;
import com.neusoft.entity.User;
import com.neusoft.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class TestMybatis {
    //It is same as main method
    @Test
    public void test(){
        User user = new User();
        user.setName("JasonC");
        user.setId(200);
        System.out.println(user);
    }
    @Test
    public void getUserById(){
        try {
            SqlSession sqlSession = MybatisUtil.getSession();
            IUserDao iUserDao=sqlSession.getMapper(IUserDao.class);
            //用$写SQL语句：必须加''才能够被识别为SQL语句的一部分
            User user=iUserDao.getUserByName("'cmc'");
            System.out.println(user);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void addUserAndCard(){
       Card card = new Card();
//       card.setUid(1);
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSession();
            ICardDao iCardDao=sqlSession.getMapper(ICardDao.class);
            iCardDao.addCard(card);
            System.out.println(card);
            User user = new User();
//            user.setName("aaa");
            user.setCard(card);
            IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
            iUserDao.addUser(user);
            System.out.println(user);
            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void getUserAndCard(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSession();
            IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
            User user = iUserDao.getUserById(5);
            System.out.println(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void getUserAndCardById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSession();
            IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
            User user = iUserDao.getUserAndCardById(5);
            System.out.println(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void insertOrder(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSession();
           IOrderDao iOrderDao = sqlSession.getMapper(IOrderDao.class);
           Order order = new Order();
            iOrderDao.insertOrder(order);
            System.out.println(order);
            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void queryOrder(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSession();
            IOrderDao iOrderDao = sqlSession.getMapper(IOrderDao.class);
            List<Order> orders =iOrderDao.queryOrderByUid(5);
            System.out.println(orders);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void insertLeaderAndUser(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSession();
            ILeaderDao iLeaderDao = sqlSession.getMapper(ILeaderDao.class);
            IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
            Leader leader = new Leader();
            leader.setLname("c");
            Leader leader1 = new Leader();
            leader1.setLname("d");
            iLeaderDao.addLeader(leader);
            iLeaderDao.addLeader(leader1);
            User user = new User();
            user.setName("abcd");
            User user1 = new User();
            user1.setName("abcde");
             iUserDao.addUser(user);
             iUserDao.addUser(user1);
            user.getLeaderList().add(leader);
            user.getLeaderList().add(leader1);

            user1.getLeaderList().add(leader);
            user1.getLeaderList().add(leader1);

            //give variables to relationship table
            for (Leader l : user.getLeaderList()){
                iLeaderDao.addRelation(l.getId(),user.getId());
            }
            for (Leader l : user1.getLeaderList()){
                iLeaderDao.addRelation(l.getId(),user.getId());
            }


            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void getUserAndLeader(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSession();
            IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
            User user = iUserDao.getUserById(48);
            //懒加载：若打印则看不出效果
            System.out.println(user);
              System.out.println(user.getId());
              System.out.println(user.getLeaderList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void TestCache(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSession();
           ICardDao iCardDao = sqlSession.getMapper(ICardDao.class);
            Card card1 =iCardDao.queryCardById(5);

            //sqlSession.clearCache();//清空缓存语句（也是关闭一级缓存的指令）：导致执行两次SQL并生成两个不同的对象
             sqlSession.close();
            SqlSession sqlSession1 = MybatisUtil.getSession();
            ICardDao iCardDao1 = sqlSession1.getMapper(ICardDao.class);
            Card card2 =iCardDao1.queryCardById(5);
            //正常来说，以上两句只执行一次SQL查询
            System.out.println(card1 == card2);
            //而且还只生成一个对象（因为地址是一样的，所以没有两个对象）
            //这是因为有L1 cache（一级缓存），默认是开启的
            //一级缓存在mapper中共享，二级缓存在(sql)Session中共享



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void TestIf(){

        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSession();
            ICardDao iCardDao=sqlSession.getMapper(ICardDao.class);
            //Card card = iCardDao.queryCardById(5);
            //System.out.println(card);
            List<Integer> intList =new ArrayList<Integer>();
            intList.add(5);
            intList.add(6);
            intList.add(7);
            List<Card> list=iCardDao.queryCardByIdGroup(intList);
            System.out.println(list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void updateCard(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSession();
            ICardDao iCardDao=sqlSession.getMapper(ICardDao.class);
            Card card = new Card();
            card.setId(10);
            card.setUid(44);
            System.out.println(card);
            iCardDao.updateCard(card);
            sqlSession.commit();
            Card card1 =iCardDao.queryCardById(10);
            System.out.println(card1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
