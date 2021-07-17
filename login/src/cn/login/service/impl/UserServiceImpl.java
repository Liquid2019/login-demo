package cn.login.service.impl;

import cn.login.dao.impl.UserDaoImpl;
import cn.login.domain.User;
import cn.login.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User login(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.getByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
