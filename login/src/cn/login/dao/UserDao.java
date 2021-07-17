package cn.login.dao;

import cn.login.domain.User;

public interface UserDao {
    public User getByUsernameAndPassword(String username,String password);
}
