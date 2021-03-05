package ru.trishkin.gb.lesson7.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.trishkin.gb.lesson7.entity.User;
import ru.trishkin.gb.lesson7.entity.UserAuthority;
import ru.trishkin.gb.lesson7.entity.UserRole;
import ru.trishkin.gb.lesson7.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
        initDB();
    }

    private void initDB(){
        repository.saveAll(Arrays.asList(
                new User(null, "admin", encoder.encode("pass"), UserRole.ROLE_ADMIN, UserAuthority.ADMIN),
                new User(null, "teacher", encoder.encode("pass"), UserRole.ROLE_ADMIN, UserAuthority.TEACHER),
                new User(null, "student", encoder.encode("pass"), UserRole.ROLE_STUDENT, UserAuthority.STUDENT)
        ));
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return repository.findById(id).orElse(null);
    }


    @Override
    public void deleteUserById(Long id) {
        repository.deleteUserById(id);
    }

    @Override
    public void deleteUser(User user) {
        repository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User findUser = repository.findFirstByLogin(s);
        if (findUser == null){
            throw  new UsernameNotFoundException("User not found with name: " + s);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(findUser.getRole().name()));

        return new org.springframework.security.core.userdetails.User(
                findUser.getLogin(),
                findUser.getPassword(),
                roles);

    }
}
