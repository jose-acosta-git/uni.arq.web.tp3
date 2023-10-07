package integrador3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import integrador3.dtos.StudentDto;
import integrador3.model.Student;
import integrador3.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
    private StudentRepository studentRepository;
	
	public Student save(StudentDto studentDto) {
		return studentRepository.save(convertToEntity(studentDto));
	}
	
	private Student convertToEntity(StudentDto s) {
		return new Student(s.getDni(), s.getName(), s.getLastName(), s.getAge(), s.getGender(), s.getCity(), s.getNotebookNumber());
	}
}
