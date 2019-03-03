package com.mfh.action;

import com.mfh.model.Message;
import com.opensymphony.xwork2.ModelDriven;

public class MessageAction implements ModelDriven<Message> {
    private Message msg;

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }

    public String addInput() {
        return "addInput";
    }

    public String add() {
        return "add";
    }

    @Override
    public Message getModel() {
        if (msg == null) {
            msg = new Message();
        }
        return msg;
    }
}
