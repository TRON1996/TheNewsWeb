package com.hzz.thenewsweb.action;

import com.google.gson.Gson;
import com.hzz.thenewsweb.model.User;
import com.hzz.thenewsweb.service.Userservice;
import com.hzz.thenewsweb.util.ActionUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@ParentPackage("struts-default")
public class UserAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private User user;
    private String strUser;
    private Userservice userservice;
    private String updateuserinfo;
    Gson gson = new Gson();

    @Action(value = "userAction")
    public void newInfoAction() throws Exception {
        User user = gson.fromJson(strUser, User.class);
        System.out.println(strUser);
        userservice.insert(user);
    }


    @Action(value = "loginUser")
    public void loginuser() throws Exception {
        user = gson.fromJson(strUser, User.class);
        User userbean = userservice.login(user);
        String userjson = new Gson().toJson(userbean);

        if (userbean != null) {
            ActionUtils.backuserData(userjson);
        } else {
            ActionUtils.backuserData("error");
        }
    }

    @Action(value = "updateuserinfo")
    public void upinfoUser() throws  Exception {
       User user = gson.fromJson(updateuserinfo, User.class);
         userservice.update(user);
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStrUser() {
        return strUser;
    }

    public void setStrUser(String strUser) {
        this.strUser = strUser;
    }

    public Userservice getUserservice() {
        return userservice;
    }

    public void setUserservice(Userservice userservice) {
        this.userservice = userservice;
    }

    public String getUpdateuserinfo() {
        return updateuserinfo;
    }

    public void setUpdateuserinfo(String updateuserinfo) {
        this.updateuserinfo = updateuserinfo;
    }
}
