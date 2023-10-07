package integrador3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integrador3.dtos.StudentDto;
import integrador3.model.Student;
import integrador3.repositories.StudentRepository;
import integrador3.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	@PostMapping
	public Student create(@RequestBody StudentDto studentDto) {
		return studentService.save(studentDto);
	}
	
	@GetMapping("/ordered")
	public List<Student> findAllOrdered() {
		return studentRepository.findAllByOrderByLastNameAsc();
	}
	
	@GetMapping("/byNotebookNumber/{notebookNumber}")
	public ResponseEntity<Student> getStudentByNotebookNumber (@PathVariable int notebookNumber) {
		return studentService.findByNotebookNumber(notebookNumber);
	}
}
