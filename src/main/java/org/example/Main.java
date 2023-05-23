package org.example;

import org.example.domain.Student;
import org.example.repository.StudentMysqlRepository;
import org.example.repository.StudentRepository;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentMysqlRepository();

        Student s1 = Student.builder()
                .age(23)
                .name("Nat")
                .group_id(15)
                .surname("Ost")
                .id(1234)
                .build();

        Student s2 = Student.builder()
                .age(25)
                .name("Artur")
                .group_id(15)
                .surname("Davalos")
                .id(15786)
                .build();

        Student s3 = Student.builder()
                .age(20)
                .name("Anetti")
                .group_id(15)
                .surname("Davalos")
                .id(99786)
                .build();
     //   studentRepository.saveToDatabase(s1);
      //  studentRepository.saveToDatabase(s2);
      //  studentRepository.saveToDatabase(s3);

        List<Student> students = studentRepository.findAll();
        System.out.println(students);

    }
}