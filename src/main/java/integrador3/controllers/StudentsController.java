package integrador3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integrador3.dtos.StudentDto;
import integrador3.model.Student;
import integrador3.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<StudentDto> getAll() {
		return studentService.findAll();
	}
	
	@PostMapping
	public Student create(@RequestBody StudentDto studentDto) {
		return studentService.save(studentDto);
	}
}
