package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kata.spring.boot_security.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(User user) {
        String pw = passwordEncoder.encode(user.getPassword());
        user.setPassword(pw);
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        String pw = passwordEncoder.encode(user.getPassword());
        user.setPassword(pw);
        userRepository.save(user);

    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }

    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
