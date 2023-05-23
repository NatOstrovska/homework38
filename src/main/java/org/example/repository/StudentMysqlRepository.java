package org.example.repository;

import org.example.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentMysqlRepository implements StudentRepository {

    private static final String DB_URL = "jdbc:mysql://robot-do-user-1968994-0.b.db.ondigitalocean.com:25060/db_nat";
    private static final String DB_USER = "doadmin";
    private static final String DB_PASSWORD = "AVNS_I6wlDKjGszZn1wvLr9t";
    private static final String SELECT_FROM_STUDENTS = "SELECT * FROM students";
    private static final String INSERT_INTO_STUDENTS = "INSERT INTO students (age, group_id, id, name, surname) VALUES (?, ?, ?, ?, ?)";

    @Override
    public void saveToDatabase(Student student) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(true);
            pstmt = conn.prepareStatement(INSERT_INTO_STUDENTS);
            pstmt.setInt(1, student.getAge());
            pstmt.setInt(2, student.getGroup_id());
            pstmt.setInt(3, student.getId());
            pstmt.setString(4, student.getName());
            pstmt.setString(5, student.getSurname());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    conn.close();
            } catch (SQLException ex) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public List<Student> findAll() {
        Connection conn = null;
        Statement stmt  = null;
        List<Student> result = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_FROM_STUDENTS);
            while (rs.next()) {
                Student student = Student.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .age(rs.getInt("age"))
                        .group_id(rs.getInt("group_id"))
                        .build();
                 result.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException ex) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
            }
        }

        return result;
    }

}



