package integrador3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<Student> findByNotebookNumber (int notebookNumber) {
        Student student = studentRepository.findByNotebookNumber(notebookNumber);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	private Student convertToEntity(StudentDto s) {
		return new Student(s.getDni(), s.getName(), s.getLastName(), s.getAge(), s.getGender(), s.getCity(), s.getNotebookNumber());
	}

	public ResponseEntity<List<Student>> findByGender(String gender) {
		List<Student> students = studentRepository.findByGender(gender);
	    if (!students.isEmpty()) {
	        return ResponseEntity.ok(students);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
