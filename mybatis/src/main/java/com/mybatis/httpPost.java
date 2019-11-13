package com.mybatis;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.net.URI;

public class httpPost {
    @Test
   public void LoginTest() {
        //测试公司的API接口，将json当做一个字符串传入httppost的请求体
        String result = null;
        HttpClient client = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder();
        URI uri = null;
        try {
            uri = builder.setScheme("http")
                    .setHost("219.136.9.83:8092")
                    .setPath("/sgtcManager-consumer/sgtc/user/SUser005")
                    .build();

            HttpPost post = new HttpPost(uri);
            //设置请求头
            post.setHeader("Content-Type", "application/json");
            String body= "{\"catalogueOne\":\"\",\"catalogueTwo\":\"\",\"channelCode\":\"03\",\"custCode\":\"\",\"operaterName\":\"\",\"sLoginId\":\"admin\",\"sPassWord\":\"aa36867ec6ee6c5dc978dd7e02fc9218\",\"sbOperator\":\"\",\"verification\":\"1234\"}";

//            String body = "{\"Key\": \"\",\"Secret\": \"\"}";
            //设置请求体
            post.setEntity(new StringEntity(body));
            //获取返回信息
            HttpResponse response = client.execute(post);
            result = EntityUtils.toString(response.getEntity(),"utf-8");
        } catch (Exception e) {
            System.out.println("接口请求失败"+e.getStackTrace());
        }
        System.out.println(result);
    }
}
