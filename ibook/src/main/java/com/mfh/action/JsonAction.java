package com.mfh.action;

import com.mfh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: mfh
 * @Date: 2019-02-26 16:00
 **/
public class JsonAction extends BaseAction {
    private String result;
    private String data;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Map<String, User> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, User> dataMap) {
        this.dataMap = dataMap;
    }

    private Map<String, User> dataMap;
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String openJsonPage() {
        return "openJsonPage";
    }

    public String json() {
        JSONObject jsonObject = JSONObject.fromObject(this.getZ3());
        result = jsonObject.toString();
        return "json_0";
    }

    public String json1() {
        result = "hello";
        data = "goods";
        dataMap = new HashMap<>();
        dataMap.put("张三", this.getZ3());
        dataMap.put("李四", this.getL4());
        return "json_1";
    }

    public String json2() {
       /* users = new ArrayList<>();
        users.add(this.getL4());
        users.add(this.getZ3());
        JSONArray jsonObject = JSONArray.fromObject(users);
        result = jsonObject.toString();*/
        return "json_2";
    }

    public String json3() {
        users = new ArrayList<>();
        users.add(this.getL4());
        users.add(this.getZ3());
        return "json_3";
    }

    public String json4() {
        users = new ArrayList<>();
        users.add(this.getL4());
        users.add(this.getZ3());
        JSONArray ja = JSONArray.fromObject(users);
        result = ja.toString();
        return "json_4";
    }

    public String json5() {
        users = new ArrayList<>();
        users.add(this.getL4());
        users.add(this.getZ3());
        JSONArray ja = JSONArray.fromObject(users);
        result = ja.toString();
        return "json_5";
    }

    public String json6() {
        users = new ArrayList<>();
        users.add(this.getL4());
        users.add(this.getZ3());
        JSONArray ja = JSONArray.fromObject(users);
        result = ja.toString();
        return "json_6";
    }

    public String json7() {
        users = new ArrayList<>();
        users.add(this.getL4());
        users.add(this.getZ3());
        return "json_7";
    }

    public void json8() {
        System.out.println("json8");
        users = new ArrayList<>();
        users.add(this.getZ3());
        users.add(this.getL4());
        super.writeJson(users);
    }

    public String json9() {
        List<User> u = new ArrayList<>();
        u.add(this.getZ3());
        u.add(this.getL4());
        ActionContext.getContext().put("us", u);
        return "json_9";
    }

    private User getZ3() {
        User user = new User();
        user.setName("z3");
        user.setAge(20);
        return user;
    }

    private User getL4() {
        User user = new User();
        user.setName("l4");
        user.setAge(39);
        return user;
    }
}
