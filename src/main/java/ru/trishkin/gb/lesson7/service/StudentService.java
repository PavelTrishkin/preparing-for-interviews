package ru.trishkin.gb.lesson7.service;

import ru.trishkin.gb.lesson7.entity.Student;

import java.util.List;

public interface StudentService {
    Student findById(Long id);
    List<Student> getAll();
    void removeById(Long id);
    void removeStudent(Student student);
    void saveOrUpdate(Student student);
}
