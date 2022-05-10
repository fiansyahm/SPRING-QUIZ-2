package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      user.setId(rs.getInt("id"));
      user.setEmail(rs.getString("email"));
      user.setPassword(rs.getString("password"));
      user.setName(rs.getString("name"));
      user.setIsAdmin(rs.getInt("isAdmin"));
      return user;
   }
}