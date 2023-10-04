package integrador3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integrador3.dtos.CourseDto;
import integrador3.model.Course;
import integrador3.services.CourseService;

@RestController
@RequestMapping("/courses")
public class CoursesController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping
	public Course create(@RequestBody CourseDto courseDto) {
		return courseService.save(courseDto);
	}
	
	@GetMapping
	public List<CourseDto> getAll() {
		return courseService.findAll();
	}
}