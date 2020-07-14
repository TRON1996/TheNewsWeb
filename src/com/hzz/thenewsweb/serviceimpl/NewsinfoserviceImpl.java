package com.hzz.thenewsweb.serviceimpl;


import com.hzz.thenewsweb.dao.NewsinfoDao;
import com.hzz.thenewsweb.model.News;
import com.hzz.thenewsweb.service.Newsinfoservice;


import java.sql.SQLException;
import java.util.List;

public class NewsinfoserviceImpl implements Newsinfoservice {
	private NewsinfoDao newsinfodao;

	@Override
	public Object insert(News news) {
		// TODO Auto-generated method stub
		return newsinfodao.save(news);
	}

	@Override
	public List<News> select() throws SQLException {
		String hql="from News";
		return newsinfodao.select(hql);
	}

	@Override
	public News datialShow(int newId) throws SQLException {
		return newsinfodao.findByID(News.class,newId);
	}

	public NewsinfoDao getNewsinfodao() {

		return newsinfodao;
	}

	public void setNewsinfodao(NewsinfoDao newsinfodao) {

		this.newsinfodao = newsinfodao;
	}

	

	
	
	


}
