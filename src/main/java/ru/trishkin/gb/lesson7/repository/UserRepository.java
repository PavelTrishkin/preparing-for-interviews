package ru.trishkin.gb.lesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trishkin.gb.lesson7.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByLogin(String login);

    void deleteUserById(Long id);
}
