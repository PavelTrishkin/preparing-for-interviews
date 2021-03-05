package ru.trishkin.gb.lesson7.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.trishkin.gb.lesson7.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAll();
    void save(User user);
    User findUserById(Long id);
    void deleteUserById(Long id);
    void deleteUser(User user);
}
