package ru.trishkin.gb.lesson7.service;

import org.springframework.stereotype.Service;
import ru.trishkin.gb.lesson7.entity.Student;
import ru.trishkin.gb.lesson7.repository.StudentRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
        init();
    }

    private void init(){
        repository.saveAll(Arrays.asList(
                new Student(null, "Petr", 21),
                new Student(null, "Vasya", 25)
        ));
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void removeStudent(Student student) {
        repository.delete(student);
    }

    @Override
    public void saveOrUpdate(Student student) {
        repository.save(student);
    }
}
