package org.example.repository;

import org.example.domain.Student;

import java.util.List;

public interface StudentRepository {
    void saveToDatabase(Student student);
    List<Student> findAll();

}
