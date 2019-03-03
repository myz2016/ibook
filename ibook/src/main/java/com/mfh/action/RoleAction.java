package com.mfh.action;

public class RoleAction {
    public String add() {
        System.out.println("Role add");
        return "add";
    }

    public String addInput() {
        System.out.println("Role addInput");
        return "addInput";
    }

    public String list() {
        System.out.println("Role list");
        return "list";
    }
}
