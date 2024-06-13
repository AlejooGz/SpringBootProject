package main.java.com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.com.example.crud.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}
