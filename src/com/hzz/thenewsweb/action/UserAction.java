package com.hzz.thenewsweb.action;

import com.google.gson.Gson;
import com.hzz.thenewsweb.model.User;
import com.hzz.thenewsweb.service.Userservice;
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
    private String ni;
    private String strUser;
    private Userservice userservice;
    HttpServletResponse response= ServletActionContext.getResponse();
    Gson gson = new Gson();
    @Action(value = "userAction")
    public void newInfoAction() throws Exception {
          User user = gson.fromJson(strUser, User.class);
        System.out.println(strUser);
        userservice.insert(user);
    }


    @Action(value = "loginUser")
    public void loginuser()throws Exception{
        user=gson.fromJson(strUser,User.class);
        User userbean=userservice.login(user);
        String userjson=new Gson().toJson(userbean);
        PrintWriter pw=response.getWriter();
        response.setCharacterEncoding("utf-8");
        if(userbean!=null){
        pw.write(userjson);
        pw.flush();
        pw.close();
        }else {
            ActionContext.getContext().getSession().put("msg","账号密码错误");
            pw.write("error");
            pw.flush();
            pw.close();
        }
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
}
