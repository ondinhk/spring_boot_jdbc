package com.odkhang.spring_jdbc.dao.imlp;

import com.odkhang.spring_jdbc.dao.IDao;
import com.odkhang.spring_jdbc.models.user.UserModel;
import com.odkhang.spring_jdbc.models.user.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserDao implements IDao<UserModel> {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Optional<UserModel> get(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserModel> getByName(String name) {
        try {
            String sql = "SELECT * FROM user WHERE name = ?";
            UserModel data = jdbc.queryForObject(
                    sql, new Object[]{name}, new UserRowMapper());
            return Optional.ofNullable(data);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public int save(UserModel userEntity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO user(name, email, address, telephone) VALUES (?, ?, ?, ?)";
        int rowsAffected = jdbc.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, userEntity.getName());
            preparedStatement.setString(2, userEntity.getEmail());
            preparedStatement.setString(3, userEntity.getAddress());
            preparedStatement.setString(4, userEntity.getTelephone());
            return preparedStatement;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    @Override
    public Collection<UserModel> getAll() {
        return null;
    }

    @Override
    public void update(UserModel userEntity) {

    }

    @Override
    public void delete(UserModel userEntity) {

    }
}
