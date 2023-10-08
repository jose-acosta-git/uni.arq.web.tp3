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

import integrador3.dtos.CreateEnrollmentDto;
import integrador3.dtos.EnrollmentDto;
import integrador3.model.Enrollment;
import integrador3.services.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentsController {
	
	@Autowired
	EnrollmentService enrollmentService;
	
	@GetMapping
	public List<EnrollmentDto> findAll() {
		return enrollmentService.findAll();
	}
	
	@PostMapping
	public Enrollment save(@RequestBody CreateEnrollmentDto dto) {
		return enrollmentService.save(dto);
	}
	
    @GetMapping("/studentsByCourseAndCity/{courseName}/{cityName}")
    public ResponseEntity<List<Enrollment>> getStudentsByCourseAndCity(
            @PathVariable("courseName") String courseName,
            @PathVariable("cityName") String cityName) {
        return enrollmentService.getStudentsByCourseAndCity(courseName, cityName);
    }
}
