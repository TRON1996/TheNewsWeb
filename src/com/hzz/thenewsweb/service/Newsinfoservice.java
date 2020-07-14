package com.hzz.thenewsweb.service;


import com.hzz.thenewsweb.model.News;


import java.sql.SQLException;
import java.util.List;

public interface Newsinfoservice {
Object insert(News news);
 List<News> select() throws SQLException;
 News datialShow(int newId) throws SQLException;
}
