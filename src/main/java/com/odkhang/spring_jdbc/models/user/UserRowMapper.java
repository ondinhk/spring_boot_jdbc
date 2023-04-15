package com.odkhang.spring_jdbc.models.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        UserModel user = new UserModel();
        user.setName(rs.getString("NAME"));
        user.setEmail(rs.getString("EMAIL"));
        user.setAddress(rs.getString("ADDRESS"));
        user.setTelephone(rs.getString("TELEPHONE"));
        return user;
    }
}
