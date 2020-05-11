package com.second.jpaoracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.second.jpaoracle.dao.UserDao;
import com.second.jpaoracle.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
    UserDao userDao;

    public List<User> getAllUsers() {
        return this.userDao.findAll();
    }

    public User addUser(User user) {
        return this.userDao.save(user);
    }

}
