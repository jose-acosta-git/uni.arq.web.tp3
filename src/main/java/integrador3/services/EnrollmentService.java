package integrador3.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import integrador3.dtos.CreateEnrollmentDto;
import integrador3.dtos.EnrollmentDto;
import integrador3.model.Course;
import integrador3.model.Enrollment;
import integrador3.model.Student;
import integrador3.repositories.CourseRepository;
import integrador3.repositories.EnrollmentRepository;
import integrador3.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentRepository enrollmentRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	public List<EnrollmentDto> findAll() {
		List<Enrollment> enrollments = enrollmentRepository.findAll();
		List<EnrollmentDto> dtos = new LinkedList<>();
		enrollments.forEach(e -> dtos.add(convertToDto(e)));
		return dtos;
	}
	
	public Enrollment save(CreateEnrollmentDto dto) {
		Enrollment enrollment = convertToEntity(dto);
		return enrollmentRepository.save(enrollment);
	}
	
    public ResponseEntity<List<Enrollment>> getStudentsByCourseAndCity(String courseName, String cityName) {
    	List<Enrollment> enrollments = enrollmentRepository.findEnrollmentsByCourseNameAndCityName(courseName, cityName);
        if (!enrollments.isEmpty()) {
            return ResponseEntity.ok(enrollments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	private EnrollmentDto convertToDto(Enrollment e) {
		return new EnrollmentDto(e.getId(), e.getStudent().getName(), e.getCourse().getName(), e.getEntryDate(), e.getExitDate());
	}
	private Enrollment convertToEntity(CreateEnrollmentDto dto) {
		Optional<Student> student = studentRepository.findById(dto.getStudentId());
		if (!student.isPresent()) {
			 throw new EntityNotFoundException("Student not found with ID: " + dto.getStudentId());
		}
		
		Optional<Course> course = courseRepository.findById(dto.getCourseId());
		if (!course.isPresent()) {
			 throw new EntityNotFoundException("Course not found with ID: " + dto.getCourseId());
		}
		
		return new Enrollment(student.get(), course.get(), dto.getEntryDate(), dto.getExitDate());
	}
}
