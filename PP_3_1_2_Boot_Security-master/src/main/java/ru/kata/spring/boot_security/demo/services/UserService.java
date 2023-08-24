package ru.kata.spring.boot_security.demo.services;


import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> allUsers();

    User getUser(Long id);

    void addUser(User user);

    void updateUser(User user);

    User getUserByUsername(String username);

    void deleteUser(Long id);
}
