package com.odkhang.spring_jdbc.services.imlp;

import com.odkhang.spring_jdbc.dao.imlp.UserDao;
import com.odkhang.spring_jdbc.models.user.UserModel;
import com.odkhang.spring_jdbc.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserDao userDao;

    @Override
    public int createUser(UserModel user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUser(String name) {

    }

    @Override
    public Optional<UserModel> getUserByName(String name) {
        Optional<UserModel> user;
        user = userDao.getByName(name);
        return user;
    }

    @Override
    public List<UserModel> getAllUser() {
        return null;
    }

    @Override
    public String hello() {
        return "Hello World";
    }
}
