package com.mybatis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.net.www.http.HttpClient;

import java.io.InputStream;

@Slf4j

public class MybatisTest {
    public static void main( String[] args ) throws Exception {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            //从数据库中读取信息，并转换为Json格式，null转换为""
            //UserDemo userCount = sqlSession.selectOne("MyMapper.getUserCount", 1);
            ManagementLoginCase userCount = sqlSession.selectOne("MyMapper.sgtcLogin", 1);
            System.out.println(userCount);
            String JsonUsers= JSON.toJSONString(userCount,SerializerFeature.WriteNullStringAsEmpty);
            System.out.println(JsonUsers);

//            发送post请求，并发送


        } finally {
            sqlSession.close();
        }
//        return JsonUsers;
// s


    }
}


