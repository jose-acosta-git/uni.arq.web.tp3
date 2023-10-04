package integrador3.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import integrador3.dtos.CourseDto;
import integrador3.model.Course;
import integrador3.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public Course save(CourseDto courseDto) {
		return courseRepository.save(convertToEntity(courseDto));
	}
	
	public List<CourseDto> findAll() {
		List<Course> courses = courseRepository.findAll();
		List<CourseDto> dtos = new LinkedList<>();
		courses.forEach(c -> dtos.add(convertToDto(c)));
		return dtos;
	}
	
	private Course convertToEntity(CourseDto dto) {
		return new Course(dto.getName());
	}
	private CourseDto convertToDto(Course course) {
		return new CourseDto(course.getName());
	}
}
