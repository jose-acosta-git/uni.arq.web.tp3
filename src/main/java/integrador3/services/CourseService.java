package integrador3.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import integrador3.dtos.CourseDto;
import integrador3.dtos.CourseReportDto;
import integrador3.dtos.CourseWithStudentsCountDto;
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
	
	public ResponseEntity<List<CourseReportDto>> generateCourseReport() {
		List<CourseReportDto> courses = courseRepository.generateCourseReport();
	    if (!courses.isEmpty()) {
	        return ResponseEntity.ok(courses);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	private Course convertToEntity(CourseDto dto) {
		return new Course(dto.getName());
	}
	private CourseDto convertToDto(Course course) {
		return new CourseDto(course.getName());
	}

	public ResponseEntity<List<CourseWithStudentsCountDto>> findCoursesWithRegisteredStudentsOrderByStudentCount() {
	    List<CourseWithStudentsCountDto> courses = courseRepository.findCoursesWithRegisteredStudentsOrderByStudentCount();
	    if (!courses.isEmpty()) {
	        return ResponseEntity.ok(courses);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
