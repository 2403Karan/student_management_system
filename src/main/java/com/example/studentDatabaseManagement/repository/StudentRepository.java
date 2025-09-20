package com.example.studentDatabaseManagement.repository;
// it is  used for data access command
import com.example.studentDatabaseManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // this is directly accessible by springboot and all function are define in its class
public interface StudentRepository extends JpaRepository<Student, Long> {
}
