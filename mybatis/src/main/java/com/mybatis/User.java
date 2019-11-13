/**
package com.mybatis;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//创建User类，并定义属性
@Data
public class User {
    private String name;
    private Integer age;

//    public String getName(){
//        return name;
//    }
//
//    public void setName(String name){
//        this.name=name;
//    }
//
//    public Integer getAge(){
//        return age;
//    }
//    public void setAge(Integer age){
//        this.age=age;
//
//    }
//
//    @Override
//    public String toString(){
//        return "User:[name="+name+",age="+age;
//    }
}


 class userGroup {
    private String name;
    private List<User> users = new ArrayList<User>();

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    //    返回user对象
    public List<User> getUsers() {
        return users;
    }

    public void setUsers( List<User> users ) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "userGroup:[name=" + name + ",users+" + users;
    }
}
class JsonTest{
    public  void main(String[] args){
        User guestUser=new User();
        guestUser.setName("guest");
        guestUser.setAge(28);

        User rootUser=new User();
        rootUser.setName("root");
        rootUser.setAge(30);

//        userGroup group=new userGroup();
//        group.setName("admin");
//        group.getUsers().add(guestUser);
//        group.getUsers().add(rootUser);

//        String JsonString=JSON.toJSONString(group);
//        System.out.println(JsonString);

        User[] users=new User[2];
        users[0]=guestUser;
        users[1]=rootUser;
//
        String jsonString2=JSON.toJSONString(users);
        System.out.println(jsonString2);
    }
}



**/


