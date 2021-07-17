package cn.login.dao.impl;

import cn.login.dao.UserDao;
import cn.login.domain.User;
import cn.login.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User getByUsernameAndPassword(String username,String password) {
        String sql="select * from user where username=? and password=?";
        User user1 = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
        return user1;
    }
}
