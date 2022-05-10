package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class FoodMapper implements RowMapper<Food> {
   public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
      Food user = new Food();
      user.setId(rs.getInt("id"));
      user.setImage(rs.getString("image"));
      user.setName(rs.getString("name"));
      user.setDescription(rs.getString("description"));
      user.setPrice(rs.getInt("price"));
      return user;
   }
}