package com.hzz.thenewsweb.serviceimpl;


import com.hzz.thenewsweb.dao.NewsinfoDao;
import com.hzz.thenewsweb.model.News;
import com.hzz.thenewsweb.service.Newsinfoservice;

public class NewsinfoserviceImpl implements Newsinfoservice {
	private NewsinfoDao newsinfodao;

	@Override
	public Object insert(News news) {
		// TODO Auto-generated method stub
		return newsinfodao.save(news);
	}

	public NewsinfoDao getNewsinfodao() {
		return newsinfodao;
	}

	public void setNewsinfodao(NewsinfoDao newsinfodao) {
		this.newsinfodao = newsinfodao;
	}

	

	
	
	


}
