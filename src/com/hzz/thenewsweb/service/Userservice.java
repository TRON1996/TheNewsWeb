package com.hzz.thenewsweb.service;


import com.hzz.thenewsweb.model.User;

import java.sql.SQLException;

/*关于个人信息的接口服务*/
public interface Userservice {//已在Spring中注册

    Object insert(User user);//创建存储user信息的接口，类型为object

    User login(User user) throws SQLException;

    void update(User user);

}
