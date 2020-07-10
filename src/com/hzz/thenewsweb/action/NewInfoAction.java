package com.hzz.thenewsweb.action;

import com.google.gson.Gson;
import com.hzz.thenewsweb.model.News;
import com.hzz.thenewsweb.service.Newsinfoservice;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;


@ParentPackage("struts-default")
public class NewInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private News news;
	private String strNews;
	private Newsinfoservice newsinfoservice;
	 Gson gson =new Gson();
	


	@Action(value = "NewInfoAction")
	public void newInfoAction() throws Exception {
		News news=gson.fromJson(strNews, News.class);
		System.out.println(strNews);
		newsinfoservice.insert(news);
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
