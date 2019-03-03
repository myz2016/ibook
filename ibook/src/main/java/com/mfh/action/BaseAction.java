package com.mfh.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

/**
 * @Author: mfh
 * @Date: 2019-02-27 13:39
 **/
public class BaseAction {
    public void writeJson(Object obj) {
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        String json;
        if (obj instanceof List) {
             json = JSONArray.fromObject(obj).toString();
            try {
                ServletActionContext.getResponse().getWriter().write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            json = JSONObject.fromObject(obj).toString();
            try {
                ServletActionContext.getResponse().getWriter().write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            ServletActionContext.getResponse().getWriter().flush();
            ServletActionContext.getResponse().getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
