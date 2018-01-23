package com.example.sfhan.aaa;

/**
 * Created by sfhan LiuXiaoDong on 2018/1/22.
 */

public class memBean {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String name;
    public String age;
    public String sex;
    public memBean(String names,String ages,String sexs){
        name=names;
        sex=sexs;
        age=ages;
    }
}
