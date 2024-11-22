package com.example.assessment.repository;

import com.example.assessment.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate template;

    public StudentRepository(JdbcTemplate template) {
        this.template = template;
    }

    @PostConstruct
    public void createTable() {
        // Check if the table already exists
        String checkTableQuery = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'STUDENT'";
        Integer tableCount = template.queryForObject(checkTableQuery, Integer.class);

        // Create the table only if it does not exist
        if (tableCount == null || tableCount == 0) {
            template.execute("CREATE TABLE student (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), gender VARCHAR(1))");
            System.out.println("Table 'STUDENT' created successfully.");
        } else {
            System.out.println("Table 'STUDENT' already exists.");
        }
    }

    public void createStudent(String name, String gender) {
        // Exclude the 'id' column from the INSERT statement
        template.update("INSERT INTO student (name, gender) VALUES (?, ?)", name, gender);
    }

    // Question 3: Find students whose names start with a given string
    // You need to run this method in AssessmentApplication.java, then it will show the output.
    public List<Student> findStudentByName(String nameStartsWith) {
        // Query students whose names start with the provided string
        String sql = "SELECT name, gender FROM student WHERE name LIKE ?";
        return template.query(
                sql,
                new Object[]{nameStartsWith + "%"},
                (ResultSet rs, int rowNum) -> new Student(rs.getString("name"), rs.getString("gender"))
        );
    }
}
