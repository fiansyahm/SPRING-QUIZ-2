package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CategoryMapper implements RowMapper<Category> {
   public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
      Category user = new Category();
      user.setId(rs.getInt("id"));
      user.setImage(rs.getString("image"));
      user.setName(rs.getString("name"));
      return user;
   }
}