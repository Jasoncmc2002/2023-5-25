package com.neusoft.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
//封装 获得SqlSession 的重复部分
public class MybatisUtil {
    //将数据库链接异常交给Service层处理
    public static SqlSession getSession() throws IOException {
        SqlSession sqlSession =null;
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

        //2.Create SqlSessionFactory Object
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //3.Create SqlSession Object(=connection in JDBC)
        //true = autocommit ON
        sqlSession = sqlSessionFactory.openSession(false);

        return sqlSession;
    }

}
