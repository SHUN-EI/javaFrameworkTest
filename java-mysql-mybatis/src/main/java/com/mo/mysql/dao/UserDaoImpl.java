package com.mo.mysql.dao;

import com.mo.mysql.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mo on 2021/10/27
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public Boolean add(User user) {
        String sql = "insert into user(id,name) values(?,?)";
        int result = jdbcTemplate.update(sql, user.getId(), user.getName());
        return result > 0;
    }

    @Transactional
    @Override
    public Boolean update(User user) {
        String sql = "update user set name=? where id=?";
        int result = jdbcTemplate.update(sql, user.getName(), user.getId());
        return result > 0;
    }

    @Transactional
    @Override
    public Boolean delete(Long id) {
        String sql = "delete from user where id=?";
        int result = jdbcTemplate.update(sql, id);
        return result > 0;
    }

    @Override
    public User queryById(Long id) {
        String sql = "select * from user where id=?";

        //重写RowMapper方法
//        class UserRowMapper implements RowMapper<User> {
//            @Override
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                User user = new User();
//                user.setId(rs.getLong("id"));
//                user.setName(rs.getString("name"));
//                return user;
//            }
//        }
//
//        User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
//
//        return user != null ? user : null;

        //RowMapper方法的Lambda表达式
        User reslut = jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {

            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            return user;
        }, id);

        return reslut != null ? reslut : null;
    }

    @Override
    public List<User> queryUserByName(String name) {
        String sql = "select * from user where name like ?";
        String nameParam = "%" + name + "%";

        //重写ResultSetExtractor方法
//        class UserResultSet implements ResultSetExtractor<List<User>> {
//            @Override
//            public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
//
//                List<User> users = new ArrayList<>();
//                while (rs.next()) {
//                    User user = new User();
//                    user.setId(rs.getLong("id"));
//                    user.setName(rs.getString("name"));
//                    users.add(user);
//                }
//                return users;
//            }
//        }
//
//        List<User> results = jdbcTemplate.query(sql, new UserResultSet(), nameParam);
//
//        return results.size() > 0 ? results : null;

        List<User> results = jdbcTemplate.query(sql, (ResultSet rs) -> {
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                users.add(user);
            }
            return users;
        }, nameParam);

        return results.size() > 0 ? results : null;
    }
}
