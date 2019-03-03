package com.mfh.action;


import com.mfh.model.User;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserAction {
    /*
    * 传值
    *   1、定义成员变量，如：name，age
    *   2、提供set/get方法
    *   3、调用setXXX()方法设置值
    *   4、在页面使用EL表达式接收值，如：${name}
    *   5、也可以使用struts2的标签库，如：<s:property value="name"/>
    *
    * */
    private String name;
    private String age;
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String add() {
        System.out.println("add");
        return "re_list";
    }

    public String addInput() {
        System.out.println("addInput");
        return "addInput";
    }

    public String list() {
        //传值的第一种方式，直接通过在action中设置相应的set和get方法
        this.setName("张三");
        this.setAge("32");
        //第二种方式通过ActionContext完成值的传递
        ActionContext.getContext().put("password", "KT102b");
        ActionContext.getContext().put("num", 123);
        //第三种方式通过ServletActionContext传值
        ServletActionContext.getRequest().setAttribute("gender", "男");

        /**
         * 操纵ValueStack
         * 将user对象push到ValueStack，由于栈的特性，现在栈顶的对象是user，
         * 所以/WEB-INF/User/list.jsp中 ${name}和<s:property value="name"/>
         * 取到的值是user对象的name值，而不是成员变量的name值
         */
        User user = new User("胡世仁", 32);
        ActionContext.getContext().getValueStack().push(user);
        return "list";
    }

    public String show() {
        ActionContext.getContext().put("age", new Random().nextInt(100));
        this.setName("特兰克斯");
        this.setAge("13");
        this.setId(1001);
        List<User> users = new ArrayList<User>();
        users.add(new User("孙悟空", 30));
        users.add(new User("贝吉塔", 35));
        users.add(new User("布尔玛", 30));
        users.add(new User("琪琪", 32));
        ActionContext.getContext().put("users", users);

        List<Integer> years = new ArrayList<Integer>();
        years.add(2013);
        years.add(2014);
        years.add(2015);
        ActionContext.getContext().put("years", years);
        return "show";
    }
}
