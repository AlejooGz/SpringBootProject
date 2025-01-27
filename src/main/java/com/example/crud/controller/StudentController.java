package main.java.com.example.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.example.crud.model.Student;
import main.java.com.example.crud.service.StudentService;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
	}
	
	@GetMapping
	public ResponseEntity<Page<Student>> getAllStudent(
			@RequestParam(required = false, value = "0") Integer page, 
			@RequestParam(required = false, value = "10")Integer size, 
			@RequestParam(required = false, value = "false") Boolean eneablePagination
			){
		return ResponseEntity.ok(studentService.getAllStudent(page, size, eneablePagination));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Student>> findStudentById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
	}
	
	@PutMapping
	public ResponseEntity<Student> editStudent(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.editStudent(student));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok(!studentService.existById(id));
	}
}
