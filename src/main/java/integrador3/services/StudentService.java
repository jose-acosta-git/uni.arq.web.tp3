package integrador3.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import integrador3.dtos.StudentDto;
import integrador3.model.Student;
import integrador3.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
    private StudentRepository studentRepository;
	
	public List<StudentDto> findAll() {
		List<Student> students = studentRepository.findAll();
		List<StudentDto> dtoList = new LinkedList<>();
		students.forEach(s -> dtoList.add(convertToDto(s)));
		return dtoList;
	}
	
	public Student save(StudentDto studentDto) {
		return studentRepository.save(convertToEntity(studentDto));
	}
	
	private StudentDto convertToDto(Student s) {
		return new StudentDto(s.getDni(), s.getName(), s.getLast_name(), s.getAge(), s.getGender(), s.getCity(), s.getNotebook_number());
	}
	
	private Student convertToEntity(StudentDto s) {
		return new Student(s.getDni(), s.getName(), s.getLast_name(), s.getAge(), s.getGender(), s.getCity(), s.getNotebook_number());
	}
}
