package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }
    @Override
    public void updateUser( User user) {
        userDAO.updateUser(user);

    }
    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);

    }
    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }
}
