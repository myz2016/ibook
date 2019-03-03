package com.mfh.model;

public class User {
    private String name;
    private int age;
    private Department dep;
    public int sum(int a, int b) {
        return a + b;
    }

    public String say(String words) {
        return words;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
