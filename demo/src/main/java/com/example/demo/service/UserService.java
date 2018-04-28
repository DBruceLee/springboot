package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @Description: 新增一个用户
     * @Param: [id, name, age]
     * @return: void
     * @Author: dbstar
     * @Date: 2018/4/28 下午5:16
     **/
    public void createUser(Integer id, String name, Integer age) {
        System.out.println("新增用户开始");
        jdbcTemplate.update("insert into users (id,name,age) values(?,?,?);", id, name, age);
        System.out.println("新增用户成功");
    }

    /**
     * @Description: 根据id查找用户
     * @Param: [id]
     * @return: com.example.demo.entity.User
     * @Author: dbstar
     * @Date: 2018/4/28 下午5:16
     **/
    public User findUserById(Integer id) {
        List<User> userList = jdbcTemplate.query("select * from users where id = ?", new Object[]{id}, new UserRowMapper());
        User user = null;
        if (!userList.isEmpty()) {
            user = userList.get(0);
        }
        System.out.println(user);
        return user;
    }

    /**
     * @Description: 返回用户列表所有信息
     * @Param: []
     * @return: java.util.List<com.example.demo.entity.User>
     * @Author: dbstar
     * @Date: 2018/4/28 下午5:16
     **/
    public List<User> findUsers() {
        List<User> userList = jdbcTemplate.query("select * from users", new UserRowMapper());
        return userList;
    }

    /**
     * 行映射
     */
    class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            return user;
        }

    }
}
