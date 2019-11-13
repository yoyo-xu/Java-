
package com.mybatis;

import com.alibaba.fastjson.annotation.JSONField;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDemo {

//    @JSONField(name="username")
    private String name;
//    @JSONField(name="age")
    private Integer age;
//    @JSONField(name="sex")
    private String sex;

//    private List<User> listOfUser=new ArrayList(.User)

//    @Override
//    public String toString() {
//        return "User{" +
//                "name=" + name +
//                ", age=" + age +
//                ", sex=" + sex +
//                '}';
//    }
//    @Override
//    public String toString() {
//        return "User [name=" + name + ", age=" + age + "]";
//    }
}
