package com.mybatis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.sun.org.apache.xpath.internal.operations.String;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class LoginCase {

/*
创建地址池
*/

        @BeforeTest
        public String GetData() throws IOException {
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
//                System.out.println(userCount);
                String JsonUsers = JSON.toJSONString(userCount, SerializerFeature.WriteNullStringAsEmpty);
//            System.out.println(JsonUsers);

//            发送post请求，并发送
                return JsonUsers;

            } finally {
                sqlSession.close();
            }

        }

//    }

//    class Login{
        @Test
        public String LoginTest() throws IOException {
            String result;
            JSONObject responseBody;
//            获取json请求数据
            System.out.println("测试-----");
            LoginCase loginDemo=new LoginCase();
//            json请求数据赋值给RequestData
            String RequestData=loginDemo.GetData();
            System.out.println("test****"+RequestData);

//            发送json请求
            HttpPost LoginRequest=new HttpPost("http://219.136.9.83:8092/sgtcManager-consumer/sgtc/user/SUser005");
            HttpClient client=new DefaultHttpClient();
            LoginRequest.setHeader("Content-type","application/json;charset=UTF-8");
//            LoginRequest.setEntity(new StringEntity(body));
//            LoginRequest.set("UTF-8");
            LoginRequest.setEntity(new StringEntity(RequestData));
            HttpResponse response=client.execute(LoginRequest);


//            测试发送请求
//            String body = "{\"catalogueOne\":\"\",\"catalogueTwo\":\"\",\"channelCode\":\"03\",\"custCode\":\"\",\"operaterName\":\"\",\"sLoginId\":\"admin\",\"sPassWord\":\"aa36867ec6ee6c5dc978dd7e02fc9218\",\"sbOperator\":\"\",\"verification\":\"1234\"}";

//
            result= EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println("响应数据："+result);
//            Assert.assertEquals("msg",200);
//            获取json结果，断言结果
            responseBody=JSON.parseObject(result);
            String province=responseBody.getJSONObject("result").getString("sNickName");
            String auth=responseBody.getJSONObject("result").getString("systemSessionToken");
            System.out.println("Authorizion："+auth);
            System.out.println("判断结果："+province);
            Assert.assertEquals(province,"admin");

//            public int getCodeInNumber(){
//                int responseCode;
//
//                responseCode= response.getStatusLine().getStatusCode();
//                System.out.println("This is your response code" + responseCode);
//                return responseCode;
//            }
            return auth;

        }

}


