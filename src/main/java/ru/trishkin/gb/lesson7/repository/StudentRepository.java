package ru.trishkin.gb.lesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trishkin.gb.lesson7.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
