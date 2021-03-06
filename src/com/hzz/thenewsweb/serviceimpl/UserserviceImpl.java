package com.hzz.thenewsweb.serviceimpl;

import com.hzz.thenewsweb.dao.UserDao;
import com.hzz.thenewsweb.model.User;
import com.hzz.thenewsweb.service.Userservice;

import java.sql.SQLException;
import java.util.List;

public class UserserviceImpl implements Userservice {
    private UserDao userdao;
    private User user;
    @Override
    public Object insert(User news) {
        // TODO Auto-generated method stub
        return userdao.save(news);
    }

    @Override
    public User login(User user) throws SQLException {
        String hql="from User where name=? and password=?";
        Object[] parmas={user.getName(),user.getPassword()};
        List<User> list=userdao.select(hql,parmas);
        if(list.size()!=0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void update(User user) {
        userdao.update(user);
    }

    public UserDao getUserdao() {
        return userdao;
    }

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
    }
}
