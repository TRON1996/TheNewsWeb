package com.hzz.thenewsweb.model;

import java.io.Serializable;

public class Comment implements Serializable {
	
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int id;
	    private String content;
	    private String time;
	    private User user;
	    private News news;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public News getNews() {
			return news;
		}
		public void setNews(News news) {
			this.news = news;
		}
	    
	    

}
