package com.hzz.thenewsweb.action;

import com.google.gson.Gson;
import com.hzz.thenewsweb.model.News;
import com.hzz.thenewsweb.service.Newsinfoservice;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


@ParentPackage("struts-default")
public class NewInfoAction extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private News news;
    private String strNews;
    private Newsinfoservice newsinfoservice;
    Gson gson = new Gson();
    private int newsId;

    //新闻内容上传
    @Action(value = "NewInfoAction")
    public void newInfoAction() throws Exception {
        News news = gson.fromJson(strNews, News.class);
        news.setStringimg(gson.toJson(news.getImgName()));
        System.out.println(strNews);
        newsinfoservice.insert(news);
    }

    //新闻列表展示
    @Action(value = "newsselect")
    public void newsselect() throws SQLException, IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        List<News> list = newsinfoservice.select();
        String jsonStr = new Gson().toJson(list);
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(jsonStr);
        pw.flush();
        pw.close();
    }

    //新闻详细叶内容获取
    @Action(value = "shownewsdetial")
    public void newsDetail() throws SQLException, IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        News news = newsinfoservice.datialShow(newsId);
        System.out.println(newsId);
        String detailStr = new Gson().toJson(news);
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(detailStr);
        pw.flush();
        pw.close();
    }


    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public News getNews() {
        return news;
    }


    public void setNews(News news) {
        this.news = news;
    }


    public String getStrNews() {
        return strNews;
    }


    public void setStrNews(String strNews) {
        this.strNews = strNews;
    }


    public Newsinfoservice getNewsinfoservice() {
        return newsinfoservice;
    }


    public void setNewsinfoservice(Newsinfoservice newsinfoservice) {
        this.newsinfoservice = newsinfoservice;
    }


}
